package com.example.projet_android.ui.components.modals

 import androidx.compose.material3.AlertDialog
 import androidx.compose.material3.Text
 import androidx.compose.runtime.Composable
 import androidx.compose.ui.tooling.preview.Preview
 import com.example.projet_android.R
 import com.example.projet_android.model.Item
 import com.example.projet_android.ui.components.buttons.OutlineButton
 import com.example.projet_android.ui.components.lists.AllItemsList
 import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun SelectItemModal(
    showDialog: Boolean,
    onDismiss: () -> Unit = {},
    onConfirm: (Item) -> Unit = {}
) {
    // TODO: Get items
    val items = listOf(
        Item("2", "Armor 1", R.drawable.armor1.toString(), "A solid piece of armor for protection"),
        Item("3", "Armor 2", R.drawable.armor2.toString(), "A reinforced armor with enhanced durability"),
        Item("4", "Armor 3", R.drawable.armor3.toString(), "An advanced armor offering maximum defense"),
        Item("6", "Axe", R.drawable.axe.toString(), "A sharp axe for chopping and combat"),
        Item("8", "Bomb", R.drawable.bomb.toString(), "An explosive device with immense power"),
        Item("9", "Bottle", R.drawable.bottle.toString(), "A bottle containing mysterious liquid"),
        Item("10", "Bow", R.drawable.bow.toString(), "A ranged weapon for shooting arrows"),
        Item("12", "Coins", R.drawable.coins.toString(), "A pile of valuable coins"),
        Item("13", "Crossbow", R.drawable.crossbow.toString(), "A powerful crossbow for ranged combat"),
        Item("15", "Crown", R.drawable.crown.toString(), "A majestic crown for royalty"),
        Item("16", "Death Symbol", R.drawable.death.toString(), "A symbol representing death"),
        Item("17", "Diamond", R.drawable.diamond.toString(), "A shiny and valuable diamond"),
        Item("18", "Door", R.drawable.door.toString(), "A door leading to unknown places"),
        Item("19", "Druid", R.drawable.druid.toString(), "A mystical druid character"),
        Item("20", "Fist", R.drawable.fist.toString(), "A symbol of strength and power"),
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "Select an item")
            },
            text = {
                AllItemsList(
                    items,
                    onItemClick = { item ->
                        onConfirm(item)
                        onDismiss()
                    }
                )
            },
            confirmButton = {
                OutlineButton("Cancel", onClick = onDismiss)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SelectItemModalPreview() {
    ProjetAndroidTheme {
        SelectItemModal(true)
    }
}