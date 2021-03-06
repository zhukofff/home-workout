package com.example.gym.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.example.gym.db.GymDatabase
import com.example.gym.util.DATABASE_NAME
import com.example.gym.util.PREFERENCE_NAME
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): GymDatabase {
        return Room
            .databaseBuilder(app, GymDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideWorkoutDao(db: GymDatabase) = db.workoutDao

    @Provides
    @Singleton
    fun provideWorkoutCategoryDao(db: GymDatabase) = db.categoryDao

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context):
            DataStore<Preferences> = context.createDataStore(name = PREFERENCE_NAME)
}