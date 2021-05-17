package com.example.gym.util

import com.example.gym.R

// Помощник для сопоставления id изображения и полученного кода тренировки
fun String.asDrawableId() : Int {
    return  when(this) {
        "arms_a" -> R.drawable.arms_a
        "ctgr_cardio" -> R.drawable.ctgr_cardio
        else -> R.drawable.arms_a
    }
}