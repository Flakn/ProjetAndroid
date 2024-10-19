package com.example.projet_android.api

import com.example.projet_android.api.dto.UserResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface PlayerApiService {

    @GET("users/me")
    suspend fun getCurrentUser(@Header("Authorization") authToken: String): UserResponse
}
