package com.example.gym.common

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gym.databinding.WorkoutGridItemBinding
import com.example.gym.databinding.WorkoutListItemBinding
import com.example.gym.model.Workout
import com.example.gym.util.asDrawableId

class WorkoutAdapter(private val isVertical: Boolean) : ListAdapter<Workout, RecyclerView.ViewHolder>(WorkoutCallback) {
    /*
    1.
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1){
                WorkoutVerticalViewHolder.from(parent)
        }
            else
        {
            WorkoutHorizontalViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        return if (holder is WorkoutVerticalViewHolder) {
            holder.bind(item)
        }
        else
        {
                (holder as WorkoutHorizontalViewHolder).bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isVertical) 1 else 0
    }

    object WorkoutCallback: DiffUtil.ItemCallback<Workout>() {
        override fun areContentsTheSame(oldItem: Workout, newItem: Workout): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areItemsTheSame(oldItem: Workout, newItem: Workout): Boolean {
            return oldItem.id == newItem.id
        }
    }
}

