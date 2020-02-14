package com.example.testforfitnesskit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.testforfitnesskit.FitnessKitApplication
import com.example.testforfitnesskit.R
import com.example.testforfitnesskit.data.api.createFitnessKitApi
import com.example.testforfitnesskit.model.WeekDay
import com.example.testforfitnesskit.ui.viewmodel.LessonsViewModel
import com.example.testforfitnesskit.ui.viewmodel.LessonsViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: LessonsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = provideViewModel()
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, DaysFragment())
                .commit()
        }

    }

    private fun provideViewModel(): LessonsViewModel{
        val api = createFitnessKitApi()
        val dao = (applicationContext as FitnessKitApplication).lessonsDao
        val viewModelFactory = LessonsViewModelFactory(dao, api)
        return ViewModelProvider(this, viewModelFactory).get(LessonsViewModel::class.java)
    }

    fun selectedDay(day: WeekDay){
        viewModel.loadLessons(day)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, LessonsFragment())
            .addToBackStack(null)
            .commit()
    }

}
