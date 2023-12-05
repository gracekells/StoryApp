package com.dicoding.storyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.storyapp.model.User
import com.dicoding.storyapp.model.UserResponse
import com.dicoding.storyapp.repository.AuthRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    val authenticationStatus = MutableLiveData<Boolean>()
    val userData = MutableLiveData<User>()

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            val response: Response<UserResponse> = authRepository.register(name, email, password)

            if (response.isSuccessful) {
                val user: User? = response.body()?.data
                userData.postValue(user)
                authenticationStatus.postValue(true)
            } else {
                authenticationStatus.postValue(false)
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val response: Response<UserResponse> = authRepository.login(email, password)

            if (response.isSuccessful) {
                val user: User? = response.body()?.data
                userData.postValue(user)
                authenticationStatus.postValue(true)
            } else {
                authenticationStatus.postValue(false)
            }
        }
    }
}