package com.example.projet_android.ui.components.contents

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projet_android.model.Game
import com.example.projet_android.ui.theme.ProjetAndroidTheme
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeContent(
    gamesAdmin: List<Game>,
    gamesPlayer: List<Game>,
    onGameClick: (Game) -> Unit,
    scaffoldPadding: PaddingValues,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(scaffoldPadding)
            .heightIn(max = 600.dp),
        verticalArrangement = Arrangement.Center
    ) {
        GameListContent("Admin", gamesAdmin, onGameClick = onGameClick)
        GameListContent("Player", gamesPlayer, onGameClick = onGameClick)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    ProjetAndroidTheme {
        val games1: List<Game> = listOf(
            Game("1","Partie 1", Date()),
            Game("2","Partie 2", Date()),
            Game("3","Partie avec un titre très long qui devrait être tronqué", Date()),
            Game("4","Partie 2", Date()),
            Game("5","Partie avec un titre très long qui devrait être tronqué", Date())
        )
        val games2: List<Game> = listOf(
            Game("1","Partie 1", Date()),
            Game("2","Partie 2", Date()),
            Game("3","Partie avec un titre très long qui devrait être tronqué", Date()),
            Game("4","Partie 2", Date()),
            Game("5","Partie avec un titre très long qui devrait être tronqué", Date())
        )
        HomeContent(games1, games2, onGameClick = {}, PaddingValues())
    }
}
