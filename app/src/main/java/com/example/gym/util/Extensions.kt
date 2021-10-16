package com.example.gym.util

import com.example.gym.R

// Помощник для сопоставления id изображения и полученного кода тренировки
fun String.asDrawableId() : Int {
    return  when(this) {
        "arms" -> R.drawable.arms_a
        "cardio" -> R.drawable.cardio_a
        "legs" -> R.drawable.legs_a
        "fill_favourite" -> R.drawable.ic_baseline_favorite_24
        else -> R.drawable.arms_a
    }
}