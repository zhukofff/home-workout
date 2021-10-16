package com.example.gym.common

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gym.R
import com.example.gym.databinding.WorkoutGridItemBinding
import com.example.gym.model.Workout

class WorkoutHorizontalViewHolder(private val binding: WorkoutGridItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.navDetailButton.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putParcelable("exercise", binding.workout)
            view.findNavController().navigate(R.id.navigation_detail, bundle)
        }
    }

    fun bind(workout: Workout) {
        binding.workout = workout
        binding.executePendingBindings()
        Log.v("horizontal","${workout.title}")
    }

    companion object {
        fun from(parent: ViewGroup): WorkoutHorizontalViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = WorkoutGridItemBinding.inflate(layoutInflater, parent, false)
            return WorkoutHorizontalViewHolder(binding)
        }
    }
}