package com.example.testforfitnesskit.data.api

import com.example.testforfitnesskit.model.Lesson
import com.google.gson.Gson
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FitnessKitApi {

    @GET("schedule/get_group_lessons_v2/1/")
    fun getAllLessons(): Single<List<Lesson>>
}

fun createFitnessKitApi():FitnessKitApi{
    val url = "https://sample.fitnesskit-admin.ru/"
    val client = OkHttpClient.Builder().build()
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()
    return retrofit.create(FitnessKitApi::class.java)
}