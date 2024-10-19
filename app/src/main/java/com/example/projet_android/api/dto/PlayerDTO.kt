package com.example.projet_android.api.dto

data class PlayerResponse(
    val id: String,
    val roleMaster: Boolean,
    val aliasFirstname: String,
    val user: UserResponse
)

data class UserResponse(
    val id: String,
    val username: String,
    val email: String
)