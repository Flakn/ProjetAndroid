package com.example.projet_android.api

import com.example.projet_android.api.dto.CreateInventoryResponse
import com.example.projet_android.api.dto.InventoryResponse
import com.example.projet_android.api.dto.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface PlayerApiService {

    @GET("users/me")
    suspend fun getCurrentUser(@Header("Authorization") authToken: String): UserResponse

    @GET("players/{id}/inventory")
    suspend fun getPlayerInventory(
        @Path("id") playerId: String,
        @Header("Authorization") authToken: String
    ): List<InventoryResponse>

    @POST("players/{playerId}/items/{itemId}")
    suspend fun addItemToPlayerInventory(
        @Path("playerId") playerId: String,
        @Path("itemId") itemId: String,
        @Header("Authorization") authToken: String
    ): Response<CreateInventoryResponse>
}
