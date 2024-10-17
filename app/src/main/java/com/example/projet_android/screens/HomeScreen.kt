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
import com.example.projet_android.ui.components.contents.HomeContent
import com.example.projet_android.ui.components.footers.HomeFooter
import com.example.projet_android.ui.components.headers.MainHeader
import com.example.projet_android.ui.theme.ProjetAndroidTheme
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavHostController, scaffoldPadding: PaddingValues) {
//    val context = LocalContext.current

    var gamesAdmin by remember { mutableStateOf(listOf(
        Game("1","Partie 1", Date(), isPlayerAdmin = true),
        Game("2","Partie 2", Date(), isPlayerAdmin = true),
        Game("3","Partie avec un titre très long qui devrait être tronqué", Date(), isPlayerAdmin = true),
        Game("4","Partie 2", Date(), isPlayerAdmin = true),
        Game("5","Partie avec un titre très long qui devrait être tronqué", Date(), isPlayerAdmin = true)
    )) }
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

    HomeContent(gamesAdmin, gamesPlayer, navController, scaffoldPadding)

    HomeFooter(
        onGameAdd = { gameTitle ->
            // TODO: Create the game
            gamesAdmin += Game("1", gameTitle)
        },
        navController,
        scaffoldPadding
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