package com.example.gym.huerker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.gym.R
import com.example.gym.db.GymDatabase
import com.example.gym.model.WorkoutCategory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.lang.Exception
import javax.inject.Inject
import com.google.gson.stream.JsonReader

@HiltWorker
class PopulateCategoryTableHuerker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParameters: WorkerParameters,
    private val db: GymDatabase ) :
    CoroutineWorker (appContext, workerParameters) {

    override suspend fun doWork(): Result {
        return try {
            applicationContext.resources.openRawResource(R.raw.categories).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val type = object: TypeToken<List<WorkoutCategory>>() {} .type
                    val categories: List<WorkoutCategory> = Gson().fromJson(jsonReader, type)
                    db.categoryDao.insertAll(categories)
                }
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }

}

