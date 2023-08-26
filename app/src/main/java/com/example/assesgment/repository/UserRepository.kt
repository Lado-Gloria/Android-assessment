package com.example.assesgment.repository

import com.example.assesgment.api.ApiClient
import com.example.assesgment.api.ApiInterface
import com.example.assesgment.model.UserRespond
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {

    val apiClient= ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getUser():Response<UserRespond> {
        return withContext(Dispatchers.IO) {
            apiClient.getUser()
        }
    }


}
