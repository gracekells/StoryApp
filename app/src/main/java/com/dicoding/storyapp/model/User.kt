package com.dicoding.storyapp.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class User(
    val id: String,
    val name: String,
    val email: String,
    val token: String
)
