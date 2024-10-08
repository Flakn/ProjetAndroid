package com.example.projet_android.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projet_android.screens.LoginScreen
import com.example.projet_android.screens.HomeScreen
import com.example.projet_android.screens.RegisterScreen

@Composable
fun NavGraph(navController: NavHostController, scaffoldPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController, scaffoldPadding)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController, scaffoldPadding)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController, scaffoldPadding)
        }
    }
}