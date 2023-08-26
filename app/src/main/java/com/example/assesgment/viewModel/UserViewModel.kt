package com.example.assesgment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assesgment.model.User
import com.example.assesgment.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel :ViewModel(){
    val userRepo =UserRepository()
    val userLiveData = MutableLiveData<List<User>>()
    val errLiveData = MutableLiveData<String>()


    fun fetchUser(){
        viewModelScope.launch {
            val response =userRepo.getUser()
            if (response.isSuccessful){
                userLiveData.postValue(response.body()?.users)
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())

            }
        }

    }

}