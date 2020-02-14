package com.example.testforfitnesskit.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Lesson(
    @ColumnInfo(name = "name") @SerializedName("name") val name: String,
    @ColumnInfo(name = "start_time") @SerializedName("startTime")val startTime : String,
    @ColumnInfo(name = "end_time") @SerializedName("endTime")val endTime : String,
    @ColumnInfo(name = "week_day") @SerializedName("weekDay")val weekDay: Int,
    @ColumnInfo(name = "teacher") @SerializedName("teacher")val teacher: String,
    @ColumnInfo(name = "place") @SerializedName("place")val place: String,
    @ColumnInfo(name = "description") @SerializedName("description")val description: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}