package com.example.gym.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.gym.model.Workout
import com.example.gym.model.WorkoutCategory
import com.example.gym.repository.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


const val TAG = "Home"

@HiltViewModel
class  HomeViewModel @Inject constructor(
    repository: WorkoutRepository
) : ViewModel() {

  private val recommendedUiFlow: Flow<RecommendedUiModel> =
        repository.getWorkouts().map { workouts ->
            val recommended = workouts.filter { il: Workout ->
                il.isRecommended
            }
            RecommendedUiModel(recommended)
        }

    val recommendedUiModel: LiveData<RecommendedUiModel> = recommendedUiFlow.asLiveData()

    private val categoriesUiFlow: Flow<CategoryUiModel> =
        repository.getCategories().map { categories ->
            CategoryUiModel(categories)
        }

    val categoriesUiModel: LiveData<CategoryUiModel> = categoriesUiFlow.asLiveData()

    data class CategoryUiModel (
        val categories: List<WorkoutCategory>
    )
    data class RecommendedUiModel(
        val workouts: List<Workout>
    )
}