package com.example.projet_android.api.dto

import java.util.Date

data class GameRequest(
    val name: String
)

data class GameResponse(
    val id: String,
    val status: String,
    val name: String,
    val createdAt: Date,
    val description: String,
    val player: PlayerResponse
)