package com.example.gym.db

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.gym.model.Workout;
import com.example.gym.model.WorkoutCategory

@Database(entities = [Workout::class, WorkoutCategory::class], version = 1)
abstract class GymDatabase : RoomDatabase() {
    abstract val workoutDao: WorkoutDao
    abstract val categoryDao: WorkoutCategoryDao
}