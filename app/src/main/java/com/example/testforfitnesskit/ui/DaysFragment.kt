package com.example.testforfitnesskit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testforfitnesskit.R
import com.example.testforfitnesskit.model.WeekDay
import com.example.testforfitnesskit.ui.viewmodel.LessonsViewModel
import kotlinx.android.synthetic.main.fragment_days.*

class DaysFragment : Fragment() {

    private lateinit var viewModel: LessonsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_days, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mondayButton.setOnClickListener { selectedDay(WeekDay.MONDAY)}
        tuesdayButton.setOnClickListener { selectedDay(WeekDay.TUESDAY)}
        wednesdayButton.setOnClickListener { selectedDay(WeekDay.WEDNESDAY)}
        thursdayButton.setOnClickListener { selectedDay(WeekDay.THURSDAY)}
        fridayButton.setOnClickListener { selectedDay(WeekDay.FRIDAY)}
        saturdayButton.setOnClickListener { selectedDay(WeekDay.SATURDAY)}
        sundayButton.setOnClickListener { selectedDay(WeekDay.SUNDAY)}
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = (context as MainActivity).viewModel

    }

    private fun selectedDay(weakDay: WeekDay){
        (activity as MainActivity).selectedDay(weakDay)
    }


}