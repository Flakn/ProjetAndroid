package com.example.projet_android.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projet_android.navigation.screens.HomeScreen
import com.example.projet_android.navigation.screens.LoginScreen
import com.example.projet_android.navigation.screens.RegisterScreen

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
//        composable(
//            route = "${Screen.Game.route}/{game_id}",
//            arguments = listOf(navArgument("game_id") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val gameId = getGameId(backStackEntry, navController)
//            if (gameId != null)
//                GameScreen(gameId, navController, scaffoldPadding)
//        }
//        composable(
//            route = "${Screen.AdminGame.route}/{game_id}",
//            arguments = listOf(navArgument("game_id") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val gameId = getGameId(backStackEntry, navController)
//            if (gameId != null)
//                AdminGameScreen(gameId, navController, scaffoldPadding)
//        }
    }
}

fun getGameId(backStackEntry: NavBackStackEntry, navController: NavHostController): String? {
    val gameId = backStackEntry.arguments?.getString("game_id")

    if (gameId.isNullOrEmpty()) {
//        navController.navigate(Screen.Home.route) {
//            popUpTo(Screen.Home.route) { inclusive = true }
//        }
        return null
    } else {
        return gameId
    }
}