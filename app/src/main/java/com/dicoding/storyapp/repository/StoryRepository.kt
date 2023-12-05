package com.dicoding.storyapp.repository

import com.dicoding.storyapp.model.Story
import com.dicoding.storyapp.network.ApiService
import retrofit2.HttpException
import retrofit2.Response

class StoryRepository(private val apiService: ApiService) {

    suspend fun getStories(): List<Story>{
        try{
            return apiService.getStories()
        } catch (e: HttpException){
            throw Exception("Failed to fetch stories. Please try again later")
        }
    }

    suspend fun addStory(photoUrl: String, description: String): Response<AddStoryResponse> {
        val token = userPreference.getUser().first().token
        return apiService.addStory("Bearer &token", photoUrl, description)
    }
}