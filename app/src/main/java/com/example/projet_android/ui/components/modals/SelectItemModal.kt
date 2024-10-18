package com.example.projet_android.ui.components.modals

 import androidx.compose.material3.AlertDialog
 import androidx.compose.material3.Text
 import androidx.compose.runtime.Composable
 import androidx.compose.runtime.LaunchedEffect
 import androidx.compose.runtime.collectAsState
 import androidx.compose.runtime.getValue
 import androidx.compose.ui.res.painterResource
 import androidx.compose.ui.tooling.preview.Preview
 import androidx.hilt.navigation.compose.hiltViewModel
 import com.example.projet_android.model.Item
 import com.example.projet_android.ui.components.buttons.OutlineButton
 import com.example.projet_android.ui.theme.ProjetAndroidTheme
 import com.example.projet_android.view_models.ItemViewModel

@Composable
fun SelectItemModal(
    showDialog: Boolean,
    onDismiss: () -> Unit = {},
    onConfirm: (Item) -> Unit = {}
) {
    val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjRjNDFhYmExLTE1NWEtNDhjMS05ZGM0LTI2MDI2NTExZTMwMyIsImlhdCI6MTcyOTIzNDU3OSwiZXhwIjoxNzI5MzIwOTc5fQ.uEylGgKHuQf1yKu2XXe91yRt_3DfCkpdbxmUaACgebA"
    val itemViewModel: ItemViewModel = hiltViewModel()

    val items by itemViewModel.items.collectAsState()
    val isLoading by itemViewModel.isLoading.collectAsState()
    val isError by itemViewModel.isError.collectAsState()

    LaunchedEffect(Unit) {
        itemViewModel.fetchItems(token)
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "Select an item")
            },
            text = {
                if (!isLoading) {
                    println(items[0].type.toInt())
                    println(painterResource(items[0].type.toInt()))
//                    AllItemsList(
//                        items,
//                        onItemClick = { item ->
//                            onConfirm(item)
//                            onDismiss()
//                        }
//                    )
                }
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