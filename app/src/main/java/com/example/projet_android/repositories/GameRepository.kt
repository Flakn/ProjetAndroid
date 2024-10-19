package com.example.projet_android.repositories

import com.example.projet_android.api.GameApiService
import com.example.projet_android.api.dto.GameRequest
import com.example.projet_android.model.Game
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameApiService: GameApiService) {

    suspend fun addGame(name: String, authToken: String): Game {
        val request = GameRequest(name)
        return gameApiService.addGame(request, authToken)
    }

    suspend fun getGames(authToken: String): List<Game> {
        val response = gameApiService.getGames(authToken)
        return response.map { gameResponse ->
            Game(
                id = gameResponse.id,
                name = gameResponse.name,
                createdAt = gameResponse.createdAt,
                status = gameResponse.status,
                description = gameResponse.description,
                isPlayerAdmin = gameResponse.player.roleMaster
            )
        }
    }
}
