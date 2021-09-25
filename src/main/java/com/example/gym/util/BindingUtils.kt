package com.example.gym.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gym.model.Workout
import com.example.gym.model.WorkoutCategory
import com.example.gym.ui.WorkoutCategoryAdapter

/**
 * BindingAdapter используемый для отправки списка тренировок к [WorkoutAdapter]
 */
@BindingAdapter("listData")
fun RecyclerView.bindRecyclerView(list: List<Workout>?) {
}

/*
BindingAdapter для отображения подходящих изображений тренировок
 */
@BindingAdapter("srcImage")
fun ImageView.bindImage(code: String?) {
    code?.let {
        setImageResource(it.asDrawableId())
    }
}

/**
 *  BindingAdapter, используемый для отправки списка категорий к [WorkoutCategoryAdapter]
 */

@BindingAdapter("categoryListData")
fun RecyclerView.bindList(list: List<WorkoutCategory>?) {
    val adapter = adapter  as WorkoutCategoryAdapter
    adapter.submitList(list)
}
