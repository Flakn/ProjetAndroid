package com.example.projet_android.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
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
    val gamesAdmin: List<Game> = listOf(
        Game("Partie 1", Date()),
        Game("Partie 2", Date()),
        Game("Partie avec un titre très long qui devrait être tronqué", Date()),
        Game("Partie 2", Date()),
        Game("Partie avec un titre très long qui devrait être tronqué", Date())
    )
    val gamesPlayer: List<Game> = listOf(
        Game("Partie 1", Date()),
        Game("Partie 2", Date()),
        Game("Partie avec un titre très long qui devrait être tronqué", Date()),
        Game("Partie 2", Date()),
        Game("Partie avec un titre très long qui devrait être tronqué", Date()),
        Game("Partie 2", Date()),
        Game("Partie avec un titre très long qui devrait être tronqué", Date())
    )

    MainHeader(scaffoldPadding)

    HomeContent(gamesAdmin, gamesPlayer, scaffoldPadding)

    HomeFooter(scaffoldPadding)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ProjetAndroidTheme {
        HomeScreen(rememberNavController(), PaddingValues())
    }
}