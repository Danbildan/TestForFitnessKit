package com.example.testforfitnesskit.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testforfitnesskit.R
import com.example.testforfitnesskit.model.Lesson

class LessonViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView) {

    fun bind(lesson: Lesson){
        itemView.findViewById<TextView>(R.id.nameTextView).text = lesson.name
        itemView.findViewById<TextView>(R.id.startTimeTextView).text = lesson.startTime
        itemView.findViewById<TextView>(R.id.endTimeTextView).text = lesson.endTime
        itemView.findViewById<TextView>(R.id.placeNameTextView).text = lesson.place
        itemView.findViewById<TextView>(R.id.teacherNameTextView).text = lesson.teacher
        itemView.findViewById<TextView>(R.id.descriptionTextView).text = lesson.description
    }
}