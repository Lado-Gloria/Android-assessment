package com.example.assesgment.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com") // Correct base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildClient(apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)
    }
}
