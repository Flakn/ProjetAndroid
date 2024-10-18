package com.example.projet_android.ui.components.contents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projet_android.R
import com.example.projet_android.model.Game
import com.example.projet_android.model.Inventory
import com.example.projet_android.model.Item
import com.example.projet_android.model.Player
import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun AdminGameContent(game: Game, scaffoldPadding: PaddingValues, modifier: Modifier = Modifier){
    println(game.title)

    // TODO: Get players using API
    var players by remember { mutableStateOf(listOf(
        Player("1", "Player 1", Inventory(listOf(Item("1", "Item 1", R.drawable.bow.toString())))),
        Player("2", "Player 2", Inventory(listOf(Item("2", "Item 2", R.drawable.axe.toString())))),
        Player("3", "Player 3", Inventory(listOf(Item("3", "Item 3", R.drawable.crossbow.toString())))),
        Player("4", "Player 4", Inventory(listOf(Item("4", "Item 4", R.drawable.diamond.toString()))))
    )) }

    var selectedPlayer by remember { mutableStateOf(players[0]) }

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(scaffoldPadding)
            .heightIn(max = 600.dp),
        verticalArrangement = Arrangement.Center
    ) {
        PlayerInGameContent(
            players,
            addPlayer = { players += it },
            removePlayer = { playerToRemove ->
                players = players.filter { it != playerToRemove }
                if (playerToRemove.id == selectedPlayer.id)
                    selectedPlayer = players[0]
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        AdminInventoryContent(
            players,
            selectedPlayer,
            onPlayerChange = { selectedPlayer = it },
            scaffoldPadding,
            Modifier.padding(horizontal = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AdminGameContentPreview() {
    ProjetAndroidTheme {
    val game = Game(
        "1",
        "Partie 1",
        description = "Lorem ipsum odor amet, consectetuer adipiscing elit. Finibus blandit interdum pulvinar non nostra imperdiet ut fusce. Nam egestas primis litora taciti penatibus\n" +
                "\n" +
                "Lorem ipsum odor amet, consectetuer adipiscing elit. Finibus blandit interdum pulvinar non nostra imperdiet ut fusce. Nam egestas primis litora taciti penatibus"
    )
        AdminGameContent(game, PaddingValues())
    }
}
