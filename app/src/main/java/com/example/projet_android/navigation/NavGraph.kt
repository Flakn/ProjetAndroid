package com.example.projet_android.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.projet_android.screens.GameScreen
import com.example.projet_android.screens.LoginScreen
import com.example.projet_android.screens.HomeScreen
import com.example.projet_android.screens.RegisterScreen

@RequiresApi(Build.VERSION_CODES.O)
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
        composable(
            route = "${Screen.Game.route}/{username}/{game_id}",
            arguments = listOf(
                navArgument("username") { type = NavType.StringType },
                navArgument("game_id") { type = NavType.StringType })
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username")
            val gameId = backStackEntry.arguments?.getString("game_id")

            if (username.isNullOrEmpty() || gameId.isNullOrEmpty()) {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) { inclusive = true }
                }
            } else {
                GameScreen(username, gameId, navController, scaffoldPadding)
            }
        }
    }
}