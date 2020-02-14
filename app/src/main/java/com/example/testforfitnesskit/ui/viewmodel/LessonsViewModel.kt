package com.example.testforfitnesskit.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testforfitnesskit.data.api.FitnessKitApi
import com.example.testforfitnesskit.data.database.LessonsDao
import com.example.testforfitnesskit.model.Lesson
import com.example.testforfitnesskit.model.WeekDay
import com.example.testforfitnesskit.utils.ErrorUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class LessonsViewModel(private val dao: LessonsDao, private val api: FitnessKitApi) : ViewModel() {

    private var disposable :Disposable? = null
    val loadingIsVisible = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    val lessons = MutableLiveData<List<Lesson>>()

    private var weekDay: WeekDay? = null
    fun loadLessons(weekDay: WeekDay){
        this.weekDay = weekDay
        updateLessons()
    }

    fun updateLessons(){
        disposable?.dispose()
        disposable = api.getAllLessons()
                .subscribeOn(Schedulers.io())
                .doOnSuccess {
                    dao.clearAndInsert(it)
                }.onErrorReturn {
                    handleError(it)
                    dao.getAll()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    loadingIsVisible.postValue(true)
                    error.postValue(ErrorUtils.NONE)
                }
                .doFinally {
                    loadingIsVisible.postValue(false)
                }
                .subscribe({
                    lessons.postValue( getLessonsForCurrentDay(it))
                },{
                    handleError(it)
                })

    }

    private fun getLessonsForCurrentDay(lessons: List<Lesson>): List<Lesson> {
        return lessons
            .filter { it.weekDay == weekDay!!.day()}
            .toList()
    }

    private fun handleError(it: Throwable) {
        ErrorUtils.whatError(it).let{
            error.postValue(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}