package com.example.retrofit2app

import androidx.lifecycle.ViewModel
import com.example.retrofit2app.api.ApiService
import com.example.retrofit2app.api.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityViewModel:ViewModel() {
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun makeApiRequet(){

    }
}