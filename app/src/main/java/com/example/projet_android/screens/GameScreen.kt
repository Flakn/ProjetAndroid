package com.example.projet_android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun GameScreen(username: String, gameId: String, navController: NavHostController, scaffoldPadding: PaddingValues) {
    Column (
        modifier = Modifier.padding(scaffoldPadding)
    ) {
        Text(username)
        Text(gameId)
    }
}