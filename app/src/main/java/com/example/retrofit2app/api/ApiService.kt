package com.example.retrofit2app.api

import retrofit2.Response
import retrofit2.http.GET

const val BASE_URL = "https://random.dog"
interface ApiService {
    @GET("/woof.json")
    suspend fun getRandomDog():Response<ApiData>
}