package com.example.projet_android.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projet_android.R
import com.example.projet_android.model.Inventory
import com.example.projet_android.model.Item
import com.example.projet_android.model.Player
import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun DeletablePlayerCard(
    player: Player,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth().background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = player.name, modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = false)
@Composable
fun DeletablePlayerCardPreview() {
    ProjetAndroidTheme {
        val player = Player("1", "Player 1", Inventory(listOf(Item("1", "Item 1", R.drawable.bow.toString()))))
        DeletablePlayerCard(player)
    }
}