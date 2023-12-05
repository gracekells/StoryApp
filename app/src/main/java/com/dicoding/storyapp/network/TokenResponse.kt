package com.dicoding.storyapp.network

import com.google.gson.annotations.SerializedName

data class TokenResponse (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("token") val token: String,
)