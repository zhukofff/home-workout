package com.example.gym.ui.detail

import android.graphics.LinearGradient
import android.os.CountDownTimer
import androidx.lifecycle.*
import com.example.gym.R
import com.example.gym.model.Workout
import com.example.gym.repository.WorkoutRepository
import com.example.gym.util.MILLIS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class TimerStatus {
    Off,
    Start,
    Stop
}

@HiltViewModel
class DetailViewModel
@Inject constructor(private val repo: WorkoutRepository) : ViewModel() {

    // receive workout from pepository -> dao
    // so i don't have any ID, it is possible take only from fragment

    var timerStatus = TimerStatus.Off

    private lateinit var timer: CountDownTimer

    private val workoutId = MutableLiveData<Int>()

    val exercise: LiveData<Workout> = workoutId.switchMap {
        repo.getWorkout(it)
    }

    private val mRuntime = MutableLiveData<Long>()
    val runtime : LiveData<Long> = mRuntime

    val exerciseTime: LiveData<Long> = exercise.map {it.time * MILLIS}

    fun start(id: Int) {
        workoutId.value = id
    }

    fun startTimer() {
        if (timerStatus == TimerStatus.Stop) {
            // i need to update timerStatus here?
            timer.start()
        }
        else {
            createTimer(exerciseTime.value!!)
            timer.start()
        }
        timerStatus = TimerStatus.Start
    }

    fun createTimer(duration: Long) {
        timer = object : CountDownTimer(duration, 1) {
            override fun onFinish() {
                resetTimer()
            }
            override fun onTick(millisUntilFinished: Long) {
                mRuntime.value = millisUntilFinished
            }
        }
    }

    fun stopTimer() {
        timerStatus = TimerStatus.Stop
        timer.cancel()
        // save time to DataStore preferences or ROOM ?
        exercise.value?.timeSaved = mRuntime.value
        viewModelScope.launch {
            repo.update(exercise.value)
        }
        setResumeTimer()
    }

    fun setResumeTimer() {
        // create new count timer with saved time in workout
        createTimer(exercise.value!!.timeSaved!!)
    }

    fun resetTimer() {
        timer.cancel()
        createTimer(exerciseTime.value!!)
        timerStatus = TimerStatus.Off
    }

    fun addToFavourite(isSaved: Boolean) {
        exercise.value?.isSaved = isSaved
        viewModelScope.launch {
            repo.update(exercise.value)
        }
    }
}

/*
1. Initialize DetailFragment:
    1.1 send exercise id to view model
    1.2 find it id using LiveData (asynchronous code) from repository
    1.3 what we are need for imagine timer?
        start time,
        (1) mechanism that send every second new integer value that we will display on screen =>
        observer livedata that receive it is value
        (1) equals CountDownTimer
        so i need:
        find in (1) runtime values
        if play then start
        if stop then cancel
        if refresh then cancel too but also set MillisInFuture to starting value
        i's easy!

        // click stop, timerStatus = stop
        // click play, timerStatus = play


 */