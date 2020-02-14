package com.example.testforfitnesskit

import android.app.Application
import androidx.room.Room
import com.example.testforfitnesskit.data.database.AppDatabase
import com.example.testforfitnesskit.data.database.LessonsDao

class FitnessKitApplication : Application() {

    lateinit var lessonsDao: LessonsDao

    override fun onCreate() {
        super.onCreate()

        lessonsDao = Room
            .databaseBuilder(this, AppDatabase::class.java, "fitness_kit_db")
            .build()
            .lessonsDao()
    }
}