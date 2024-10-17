package com.example.projet_android.ui.components.contents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projet_android.R
import com.example.projet_android.model.Inventory
import com.example.projet_android.model.Item
import com.example.projet_android.model.Player
import com.example.projet_android.ui.components.headers.AdminInventoryHeader
import com.example.projet_android.ui.components.lists.InventoryItemsList
import com.example.projet_android.ui.components.modals.ItemInfoModal
import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun AdminInventoryContent(
    players: List<Player>,
    scaffoldPadding: PaddingValues,
    modifier: Modifier = Modifier
){
    var showDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<Item?>(null) }
    var inventory by remember { mutableStateOf(players[0].inventory) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(scaffoldPadding)
    ) {
        AdminInventoryHeader(
            players,
            { player -> inventory = player.inventory }
        )
        InventoryItemsList(
            inventory.items,
            itemOnClick = { item ->
                showDialog = true
                selectedItem = item
            }
        )
    }

    ItemInfoModal(
        showDialog,
        selectedItem,
        onDismiss = { showDialog = false },
    )
}

@Preview(showBackground = true)
@Composable
fun AdminInventoryContentPreview() {
    ProjetAndroidTheme {
        val players = listOf(
            Player("1", "Player 1", Inventory(listOf(Item("1", "Item 1", R.drawable.bow.toString())))),
            Player("2", "Player 2", Inventory(listOf(Item("2", "Item 2", R.drawable.axe.toString())))),
            Player("3", "Player 3", Inventory(listOf(Item("3", "Item 3", R.drawable.crossbow.toString())))),
            Player("4", "Player 4", Inventory(listOf(Item("4", "Item 4", R.drawable.diamond.toString()))))
        )
        AdminInventoryContent(players, PaddingValues())
    }
}
