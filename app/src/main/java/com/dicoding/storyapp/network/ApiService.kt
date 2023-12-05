package com.dicoding.storyapp.network
import com.dicoding.storyapp.model.Story
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<UserResponse>

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<StoryResponse>

    @GET("stories")
    suspend fun getStories(
        @Header("Authorization") token: String
    ): Response<UserResponse>

    @FormUrlEncoded
    @POST("stories")
    suspend fun addStory(
        @Header("Authorization") token: String,
        @Field("photoUrl") photoUrl: String,
        @Field("description") description: String
    ): Response<AddStoryResponse>
}