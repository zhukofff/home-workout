package com.example.gym.model

import android.os.Parcelable;
import kotlinx.android.parcel.Parcelize;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Parcelize
@Entity(tableName = "workout_table") // описывает название таблицы в SQLite
class Workout (
    @PrimaryKey
    val id: Int,
    val title: String,
    val time: Long,
    val category: String,
    val iconCode: String,
    val instruction: String,
    var isSaved: Boolean,
    var timeSaved: Long?,
    var isRecommended: Boolean,
    val complexity: String
    ) : Parcelable