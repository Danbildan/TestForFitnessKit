package com.example.testforfitnesskit.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.testforfitnesskit.model.Lesson

@Dao
interface LessonsDao {
    @Query("select * from lesson")
    fun getAll(): List<Lesson>

    @Insert
    fun insertAll(lessons: List<Lesson>)

    @Query("delete from lesson")
    fun clear()

    @Transaction
    fun clearAndInsert(lessons: List<Lesson>){
        clear()
        insertAll(lessons)
    }
}