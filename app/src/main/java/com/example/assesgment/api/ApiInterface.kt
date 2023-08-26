package com.example.assesgment.api

import com.example.assesgment.model.User
import com.example.assesgment.model.UserRespond
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/user")
    suspend fun getUser(): Response<UserRespond>

    @GET("/user/{id}")
    suspend fun getUserById(@Path("id") userId: Int): Response<User>
}

