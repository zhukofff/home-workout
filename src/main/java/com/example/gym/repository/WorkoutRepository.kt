package com.example.gym.repository

import androidx.lifecycle.LiveData
import com.example.gym.db.WorkoutCategoryDao
import com.example.gym.db.WorkoutDao
import com.example.gym.model.Workout
import com.example.gym.model.WorkoutCategory
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn


class WorkoutRepository @Inject constructor(
    private val workoutDao: WorkoutDao,
     private val categoryDao: WorkoutCategoryDao
) {
    // TODO : add wrapEspressoIdlingResource
    fun getWorkouts(): Flow<List<Workout>>  = workoutDao.getWorkouts().flowOn(Dispatchers.IO)

    fun getWorkout(id: Int): LiveData<Workout> = workoutDao.getWorkout(id)

    suspend fun update(workout: Workout) = workoutDao.update(workout)

    fun getCategories(): Flow<List<WorkoutCategory>> = categoryDao.getCategories()

}