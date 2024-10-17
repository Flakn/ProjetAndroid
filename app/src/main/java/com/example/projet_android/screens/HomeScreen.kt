package com.example.projet_android.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projet_android.model.Game
import com.example.projet_android.navigation.Screen
import com.example.projet_android.ui.components.contents.HomeContent
import com.example.projet_android.ui.components.footers.HomeFooter
import com.example.projet_android.ui.components.headers.MainHeader
import com.example.projet_android.ui.components.modals.PlayerNameModal
import com.example.projet_android.ui.theme.ProjetAndroidTheme
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavHostController, scaffoldPadding: PaddingValues) {
//    val context = LocalContext.current

    var showDialog by remember { mutableStateOf(false) }
    var clickedGame by remember { mutableStateOf<Game?>(null) }

    val gamesAdmin: List<Game> = listOf(
        Game("1","Partie 1", Date(), isPlayerAdmin = true),
        Game("2","Partie 2", Date(), isPlayerAdmin = true),
        Game("3","Partie avec un titre très long qui devrait être tronqué", Date(), isPlayerAdmin = true),
        Game("4","Partie 2", Date(), isPlayerAdmin = true),
        Game("5","Partie avec un titre très long qui devrait être tronqué", Date(), isPlayerAdmin = true)
    )
    val gamesPlayer: List<Game> = listOf(
        Game("1","Partie 1", Date()),
        Game("2","Partie 2", Date()),
        Game("3","Partie avec un titre très long qui devrait être tronqué", Date()),
        Game("4","Partie 2", Date()),
        Game("5","Partie avec un titre très long qui devrait être tronqué", Date()),
        Game("6","Partie 2", Date()),
        Game("7","Partie avec un titre très long qui devrait être tronqué", Date())
    )

    MainHeader(scaffoldPadding)

    HomeContent(gamesAdmin, gamesPlayer, onGameClick = { game ->
        clickedGame = game
        showDialog = true
    }, scaffoldPadding)

    HomeFooter(navController, scaffoldPadding)

    PlayerNameModal(
        showDialog = showDialog,
        onDismiss = {
            showDialog = false
        },
        onConfirm = { playerName ->
            val route = if (clickedGame!!.isPlayerAdmin) Screen.AdminGame.route else Screen.Game.route
            if (playerName.isEmpty()) {
//                showShortAlert(context, "Please enter a valid username")
                val playerNameRoute = if (clickedGame!!.isPlayerAdmin) "" else "/test"
                navController.navigate("$route$playerNameRoute/1")
            } else {
                val playerNameRoute = if (clickedGame!!.isPlayerAdmin) "" else "/$playerName"
                navController.navigate("$route$playerNameRoute/${clickedGame!!.id}")
            }
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ProjetAndroidTheme {
        HomeScreen(rememberNavController(), PaddingValues())
    }
}