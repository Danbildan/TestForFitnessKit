package com.example.testforfitnesskit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testforfitnesskit.R
import com.example.testforfitnesskit.model.Lesson

class LessonsViewAdapter :   RecyclerView.Adapter<LessonViewHolder>() {

    private val lessons = ArrayList<Lesson>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LessonViewHolder(
            inflater.inflate(
                R.layout.item_lesson,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.bind(lessons[position])
    }

    fun add(lessons: List<Lesson>, refresh: Boolean = true){
        if (refresh) {
            this.lessons.clear()
        }
        this.lessons.addAll(lessons)
        notifyDataSetChanged()
    }
}