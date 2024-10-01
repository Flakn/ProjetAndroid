package com.example.projet_android.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.projet_android.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController, scaffoldPadding: PaddingValues) {
    Button(
        modifier = Modifier.padding(scaffoldPadding),onClick = { navController.navigate(Screen.Login.route) }) {
        Text(text = "Go to Login")
    }
}