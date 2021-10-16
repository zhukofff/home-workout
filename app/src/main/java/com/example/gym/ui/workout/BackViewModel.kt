package com.example.gym.ui.workout

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.gym.model.Workout
import com.example.gym.repository.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class BackViewModel @Inject constructor (private val repo: WorkoutRepository) : ViewModel() {

    private val backExercises = repo.getWorkouts().map { workouts ->
        workouts.filter { workout ->
            workout.category == "back"
        }
        Back(workouts)
    }

    private val backExercises_ = repo.getWorkouts().map { workouts ->
        workouts.filter{
            it.category == "back"
        }
    }

    val backWorkoutUiModel : LiveData<Back> = backExercises.asLiveData()
    val backWorkoutUiModel_ : LiveData<List<Workout>> = backExercises_.asLiveData()

    data class Back(
        val workouts: List<Workout>
    )
}