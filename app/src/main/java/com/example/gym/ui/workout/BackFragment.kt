package com.example.gym.ui.workout

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.gym.R
import com.example.gym.common.WorkoutAdapter
import com.example.gym.databinding.FragmentExerciseBinding
import com.example.gym.model.Workout
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BackFragment: Fragment() {

    private val backViewModel: BackViewModel by viewModels()
    private lateinit var binding: FragmentExerciseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExerciseBinding.inflate(inflater, container, false)
        val adapter = WorkoutAdapter(true)
        binding.listExercises.adapter = adapter

        // add line after one recycler view item
        binding.listExercises.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        val backExercises = Observer<List<Workout>> {
            adapter.submitList(it)
            for (el in it)
                Log.v("workouts", "${el.title}}")
        }
        backViewModel.backWorkoutUiModel_.observe(viewLifecycleOwner, backExercises)
        return binding.root
    }
}