package com.example.gym.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gym.common.WorkoutAdapter
import com.example.gym.model.Workout
import com.example.gym.model.WorkoutCategory
import com.example.gym.ui.home.WorkoutCategoryAdapter

@BindingAdapter("timeFormatted")
fun TextView.bindText(time: Long) {
    val text = "${time} sec"
    setText(text)
}
/**
 * BindingAdapter используемый для отправки списка тренировок к [WorkoutAdapter]
 */
@BindingAdapter("listData")
fun RecyclerView.bindRecyclerView(list: List<Workout>?) {
    val adapter = adapter as WorkoutAdapter
    adapter.submitList(list)
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
