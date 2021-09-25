package com.example.gym.huerker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.gym.R
import com.example.gym.db.GymDatabase
import com.example.gym.model.Workout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.lang.Exception
import javax.inject.Inject

@HiltWorker
class PopulateWorkoutTableHuerker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    val db: GymDatabase
) : CoroutineWorker(context, workerParameters){

    override suspend fun doWork(): Result {
        return try {
            applicationContext.resources.openRawResource(R.raw.workout). use { inputStream ->
                JsonReader(inputStream.reader()).use {
                    val type = object : TypeToken<List<Workout>>() {} .type
                    val workout : List<Workout> = Gson().fromJson(it, type)
                    Log.v("populate", "$it")
                    db.workoutDao.insertAll(workout)
                }
            }
            Result.success()
        } catch (e: Exception){
            Result.failure()
        }
    }
}

