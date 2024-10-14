package com.example.projet_android.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projet_android.R
import com.example.projet_android.model.Game
import com.example.projet_android.model.Inventory
import com.example.projet_android.model.Item
import com.example.projet_android.model.Player
import com.example.projet_android.ui.components.contents.GameContent
import com.example.projet_android.ui.components.footers.GameFooter
import com.example.projet_android.ui.components.headers.MainHeader
import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun GameScreen(username: String, gameId: String, navController: NavHostController, scaffoldPadding: PaddingValues) {
    val inventory = Inventory(
        items = listOf(
            Item("1", "Item 1", R.drawable.armor1.toString()),
            Item("2", "Item 2", R.drawable.axe.toString()),
            Item("3", "Item 3", R.drawable.bow.toString()),
            Item("4", "Item 4", R.drawable.coins.toString()),
            Item("5", "Item 5", R.drawable.heal.toString()),
            Item("6", "Item 6", R.drawable.diamond.toString()),
            Item("7", "Item 7", R.drawable.food.toString()),
            Item("8", "Item 8", R.drawable.knife.toString()),
        )
    )
    val player = Player(
        "1",
        username,
        inventory
    )
    val game = Game(
        gameId,
        "Partie 1",
        description = "Lorem ipsum odor amet, consectetuer adipiscing elit. Finibus blandit interdum pulvinar non nostra imperdiet ut fusce. Nam egestas primis litora taciti penatibus\n" +
                "\n" +
                "Lorem ipsum odor amet, consectetuer adipiscing elit. Finibus blandit interdum pulvinar non nostra imperdiet ut fusce. Nam egestas primis litora taciti penatibus"
    )

    MainHeader(scaffoldPadding, text = "${stringResource(R.string.app_name)} - $gameId")

    GameContent(player, game, scaffoldPadding)

    GameFooter(navController, scaffoldPadding)
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    ProjetAndroidTheme {
        GameScreen(
            "TestUsername",
            "1",
            rememberNavController(),
            PaddingValues()
        )
    }
}