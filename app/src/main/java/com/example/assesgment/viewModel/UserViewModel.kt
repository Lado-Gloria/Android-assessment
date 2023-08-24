package com.example.assesgment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assesgment.model.User
import com.example.assesgment.repository.UserRepository

class UserViewModel {

    val userRepo =UserRepository()
    val userLiveData = MutableLiveData<List<User>>()
    val errLiveData = MutableLiveData<String>()


    fun fetchProducts(){
        viewModelScope.launch {
            val response =userRepo.getUser()
            if (response.isSuccessful){
                userLiveData.postValue(response.body()?.user)
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())

            }
        }

    }
}