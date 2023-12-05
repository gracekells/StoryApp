package com.dicoding.storyapp.network
import com.dicoding.storyapp.model.Story
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): TokenResponse

    @GET("stories")
    suspend fun getStories(): List<Story>

    @FormUrlEncoded
    @POST("addStory")
    suspend fun addStory(
        @Field("photo") photo: String,
        @Field("description") description: String
    )
}