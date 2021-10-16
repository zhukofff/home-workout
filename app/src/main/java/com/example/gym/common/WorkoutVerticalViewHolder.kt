package com.example.gym.common

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.gym.R
import com.example.gym.databinding.WorkoutListItemBinding
import com.example.gym.model.Workout
import com.example.gym.ui.detail.DetailFragmentArgs
import com.example.gym.util.asDrawableId


class WorkoutVerticalViewHolder(private val binding: WorkoutListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var workout_ : Workout
    init {
        binding.workoutVertical.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putParcelable("exercise", workout_)

            view.findNavController().navigate(R.id.navigation_detail, bundle)
        }
    }

    fun bind(workout: Workout) {
        workout_ = workout
        binding.exerciseComplexity.text = workout.complexity
        binding.exerciseName.setText(workout.title)
        binding.imageExercise.setImageResource(workout.iconCode.asDrawableId())
        binding.exerciseTime.setText(workout.time.toString() + "sec")
        Log.v("holder", "${workout.title}")
    }

    companion object {
        fun from(parent: ViewGroup) : WorkoutVerticalViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = WorkoutListItemBinding.inflate(layoutInflater, parent, false)
            return WorkoutVerticalViewHolder(binding)
        }
    }
}