package com.example.projet_android.repositories

import com.example.projet_android.api.PlayerApiService
import com.example.projet_android.api.dto.UserResponse
import javax.inject.Inject

class PlayerRepository @Inject constructor(private val playerApiService: PlayerApiService) {

    suspend fun getCurrentUser(authToken: String): UserResponse {
        return playerApiService.getCurrentUser(authToken)
    }
}
