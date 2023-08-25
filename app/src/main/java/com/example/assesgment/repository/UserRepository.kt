package com.example.assesgment.repository

import com.example.assesgment.api.ApiClient
import com.example.assesgment.api.ApiInterface
import com.example.assesgment.model.UserRespond
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {

    private val apiInterface: ApiInterface = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getUser() {
        return withContext(Dispatchers.IO) {
            apiInterface.getUser()
        }
    }


}
