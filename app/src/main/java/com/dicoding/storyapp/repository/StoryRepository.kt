package com.dicoding.storyapp.repository

import com.dicoding.storyapp.model.Story
import com.dicoding.storyapp.network.ApiService
import retrofit2.HttpException

class StoryRepository(private val apiService: ApiService) {

    suspend fun getStories(): List<Story>{
        try{
            return apiService.getStories()
        } catch (e: HttpException){
            throw Exception("Failed to fetch stories. Please try again later")
        }
    }

    suspend fun addStory(photo: String, description: String){
        try {
            apiService.addStory(photo, description)
        } catch (e: HttpException){
            throw Exception("Failed to add a new story. Please try again later")
        }
    }
}