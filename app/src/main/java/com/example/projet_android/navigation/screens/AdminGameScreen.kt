package com.example.projet_android.navigation.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projet_android.R
import com.example.projet_android.model.Game
import com.example.projet_android.ui.components.contents.AdminGameContent
import com.example.projet_android.ui.components.footers.GameFooter
import com.example.projet_android.ui.components.headers.MainHeader
import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun AdminGameScreen(gameId: String, navController: NavHostController, scaffoldPadding: PaddingValues) {
    val game = Game(
        gameId,
        "Partie 1",
    )

    MainHeader(scaffoldPadding, text = "${stringResource(R.string.app_name)} - $gameId")

    AdminGameContent(game, scaffoldPadding)

    GameFooter(navController, scaffoldPadding)
}

@Preview(showBackground = true)
@Composable
fun AdminGameScreenPreview() {
    ProjetAndroidTheme {
        AdminGameScreen(
            "1",
            rememberNavController(),
            PaddingValues()
        )
    }
}