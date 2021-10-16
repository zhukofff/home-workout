package com.example.gym.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.map
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.gym.R
import com.example.gym.databinding.FragmentDetailBinding
import com.example.gym.model.Workout
import com.example.gym.util.MILLIS
import com.example.gym.util.asDrawableId
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    private val exercise: Workout by lazy {
        args.exercise
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel.start(exercise.id)
        binding.exerciseName.title = exercise.title
        binding.exerciseImage.setImageResource(exercise.iconCode.asDrawableId())
        binding.exerciseDescription.text = exercise.instruction

        makeNotClickable(false, false)
        binding.hideExerciseDescription.setOnClickListener {
            if (binding.exerciseDescription.isVisible == false)
                binding.exerciseDescription.isVisible = true
            else
                binding.exerciseDescription.isVisible = false
        }

        setFavourite()

        binding.exerciseName.setNavigationOnClickListener {
            Navigation.findNavController(requireView()).popBackStack()
        }

        binding.favourite.setOnClickListener {
            val favourite = binding.favourite
            // change src of image view
            val isSaved = exercise.isSaved
            if (isSaved) {
                favourite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                detailViewModel.addToFavourite(false)
            }
            else {
                favourite.setImageResource(R.drawable.ic_baseline_favorite_24)
                detailViewModel.addToFavourite(true)
            }
            // add it to Room

        }

        val time = Observer<Long> {
            binding.timerProgress.updateProgressBar(it)
            if (it == 0L) {
                makeClickable(true)
            }
        }

        val setTime = Observer<Long> {
            binding.timerProgress.setDuration(it)
            if (detailViewModel.timerStatus == TimerStatus.Off)
                binding.timerProgress.updateProgressBar(it)
        }

        detailViewModel.exerciseTime.observe(viewLifecycleOwner, setTime)
        detailViewModel.runtime.observe(viewLifecycleOwner, time)

        binding.play.setOnClickListener {
            detailViewModel.startTimer()
            makeClickable(false)
            makeNotClickable(true, false)
        }

        binding.pause.setOnClickListener {
            // send pause to savedTime
            // stop timer
            detailViewModel.stopTimer()
            makeClickable(true)
            makeNotClickable(false, true)
        }

        binding.refresh.setOnClickListener {
            detailViewModel.resetTimer()
            binding.timerProgress.updateProgressBar(detailViewModel.exerciseTime.value!!)
            makeClickable(true)
            makeNotClickable(false, false)
        }
    }

    private fun makeClickable(isPlay: Boolean) {
        if (isPlay) {
            binding.play.isClickable = true
            binding.play.alpha = 1F
        } else {
            binding.pause.isClickable = true
            binding.pause.alpha = 1F
            binding.refresh.isClickable = true
            binding.refresh.alpha = 1F
        }
    }

    private fun makeNotClickable(isPlay: Boolean, isPause: Boolean) {
        if (isPlay) {
            binding.play.isClickable = false
            binding.play.alpha = 0.5F
        } else {
            binding.pause.isClickable = false
            binding.pause.alpha = 0.5F
            if (!isPause) {
                binding.refresh.isClickable = false
                binding.refresh.alpha = 0.5F
            }
        }
    }

    private fun setFavourite() {
        if (exercise.isSaved == true)
            binding.favourite.setImageResource(R.drawable.ic_baseline_favorite_24)
    }
}

/*
1. Click play
2. timer is working
3. Click stop
4. do not move timer progress bar
5. Click refresh
6. refresh the time, set to time that in workout.time

updateProgressBar() starting from fragment

if we have exercise that have icon code and saved parameter
 */