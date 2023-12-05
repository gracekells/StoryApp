package com.dicoding.storyapp.repository

import com.dicoding.storyapp.model.User
import com.dicoding.storyapp.network.ApiService
import retrofit2.HttpException

class AuthRepository(private val apiService: ApiService) {

    suspend fun login(email: String, password: String): User {
        try {
            val tokenResponse = apiService.login(email, password)
            return User(tokenResponse.id, tokenResponse.name, email, tokenResponse.token)
        } catch (e: HttpException){
            throw Exception("Login failed. Please check your credentials.")
        }
    }
}