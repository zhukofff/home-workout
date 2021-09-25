package com.example.gym

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.gym.huerker.PopulateCategoryTableHuerker
import com.example.gym.huerker.PopulateWorkoutTableHuerker
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class GymApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        prepopulateDatabase()
    }

    fun prepopulateDatabase() {
        val populateCategory = OneTimeWorkRequestBuilder<PopulateCategoryTableHuerker>().build()
        val populateWorkout = OneTimeWorkRequestBuilder<PopulateWorkoutTableHuerker>().build()

        WorkManager.getInstance(applicationContext)
                    .beginWith(populateCategory)
                    .then(populateWorkout)
                    .enqueue()
    }
    // чтобы заинжектить хилтовский объект WorkManager
    override fun getWorkManagerConfiguration() : Configuration {
        return Configuration.Builder().setWorkerFactory(workerFactory).build()
    }
}