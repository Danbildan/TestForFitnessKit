package com.example.testforfitnesskit.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testforfitnesskit.data.api.FitnessKitApi
import com.example.testforfitnesskit.data.database.LessonsDao

class LessonsViewModelFactory(
    private val dao: LessonsDao,
    private val api: FitnessKitApi ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(LessonsDao::class.java, FitnessKitApi::class.java)
            .newInstance(dao, api)
    }
}