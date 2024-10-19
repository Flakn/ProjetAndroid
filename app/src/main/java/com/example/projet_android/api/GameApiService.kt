package com.example.projet_android.api

import com.example.projet_android.api.dto.GameRequest
import com.example.projet_android.api.dto.GameResponse
import com.example.projet_android.model.Game
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface GameApiService {

    @POST("party/create")
    suspend fun addGame(@Body request: GameRequest, @Header("Authorization") authToken: String): Game

    @GET("party")
    suspend fun getGames(@Header("Authorization") authToken: String): List<GameResponse>
}
