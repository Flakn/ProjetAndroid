package com.example.projet_android.repositories

import com.example.projet_android.api.PlayerApiService
import com.example.projet_android.api.dto.UserResponse
import com.example.projet_android.model.Inventory
import javax.inject.Inject

class PlayerRepository @Inject constructor(private val playerApiService: PlayerApiService) {

    suspend fun getCurrentUser(authToken: String): UserResponse {
        return playerApiService.getCurrentUser(authToken)
    }

    suspend fun getPlayerInventory(playerId: String, authToken: String): Inventory {
        val response = playerApiService.getPlayerInventory(playerId, authToken)
        return Inventory(items = response.map { it.item })
    }

    suspend fun addItemToPlayerInventory(playerId: String, itemId: String, authToken: String) {
        val response = playerApiService.addItemToPlayerInventory(playerId, itemId, authToken)
        if (!response.isSuccessful) {
            throw Exception("Adding item to player's inventory failed: ${response.errorBody()?.string()}")
        }
    }
}
