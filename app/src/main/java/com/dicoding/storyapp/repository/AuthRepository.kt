package com.dicoding.storyapp.repository

import androidx.lifecycle.MutableLiveData
import com.dicoding.storyapp.model.User
import com.dicoding.storyapp.network.ApiService
import retrofit2.HttpException
import retrofit2.Response

class AuthRepository(private val apiService: ApiService) {

    val authenticationStatus = MutableLiveData<Boolean>()
    val userData = MutableLiveData<User>()

    suspend fun register(name: String, email: String, password: String): Response<UserResponse> {
        return apiService.register(name, email, password)
    }

    suspend fun login(email: String, password: String): Response<UserResponse> {
        return apiService.login(email, password)
    }

    fun logout(){
        userData.postValue(null)
        authenticationStatus.postValue(false)
    }
}