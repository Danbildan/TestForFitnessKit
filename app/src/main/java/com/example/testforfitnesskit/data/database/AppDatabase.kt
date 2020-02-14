package com.example.testforfitnesskit.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testforfitnesskit.model.Lesson


@Database(entities = [Lesson::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun lessonsDao(): LessonsDao
}