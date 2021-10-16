package com.example.gym.ui.favourite

import android.util.Log
import androidx.lifecycle.*
import com.example.gym.model.Workout
import com.example.gym.repository.SortOrder
import com.example.gym.repository.UserPreferences
import com.example.gym.repository.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val repo: WorkoutRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val sortPreferences = userPreferences.userPreferencesFlow

    private val mFavouriteExercises = MutableLiveData<List<Workout>>()
    val favouriteExercises : LiveData<List<Workout>> = mFavouriteExercises

    private val mSortOrder = MutableLiveData<SortOrder>()
    val sortOrder : LiveData<SortOrder> = mSortOrder

    val favouriteExercisesFlow = repo.getWorkouts().map { exercises ->
        exercises.filter { exercise ->
            exercise.isSaved == true
        }
    }

    val combineExerciseAndOrder: Flow<List<Workout>> = sortPreferences.combine(favouriteExercisesFlow) {
            sortOrder, exercises ->
        Log.v("check", "launch sorting")
        mSortOrder.value = sortOrder
        sortingExercises(sortOrder, exercises)
    }

    init {
        receiveSortOrder()
    }

    fun updateSortOrder(order: String) {
        viewModelScope.launch {
            userPreferences.setSortOrder(order)
            combineExerciseAndOrder.collect { exercises ->
                mFavouriteExercises.value = exercises
            }
        }
    }

    fun receiveSortOrder() {
        viewModelScope.launch {
            combineExerciseAndOrder.collect { exercises ->
                mFavouriteExercises.value = exercises
            }
        }
    }



    fun sortingExercises(sortOrder: SortOrder, exercises: List<Workout>): List<Workout> {
        return when (sortOrder) {
            SortOrder.BY_TITLE -> exercises.sortedBy { it.title }
            SortOrder.BY_TIME -> exercises.sortedBy { it.time }
            SortOrder.BY_CATEGORY -> exercises.sortedBy { it.category }
            else -> exercises.sortedBy { it.complexity }
        }
    }
}