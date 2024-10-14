package com.example.projet_android.ui.components.modals

 import androidx.compose.foundation.layout.Column
 import androidx.compose.material3.AlertDialog
 import androidx.compose.material3.Text
 import androidx.compose.runtime.Composable
 import androidx.compose.runtime.getValue
 import androidx.compose.runtime.mutableStateOf
 import androidx.compose.runtime.remember
 import androidx.compose.runtime.setValue
 import androidx.compose.ui.tooling.preview.Preview
 import com.example.projet_android.ui.components.buttons.OutlineButton
 import com.example.projet_android.ui.components.buttons.ValidateButton
 import com.example.projet_android.ui.components.inputs.TextInput
 import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun PlayerNameModal(
    showDialog: Boolean,
    onDismiss: () -> Unit = {},
    onConfirm: (String) -> Unit = {}
) {
    var playerName by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "Enter your player name")
            },
            text = {
                Column {
                    TextInput(playerName, {playerName = it}, "Write your name")
                }
            },
            confirmButton = {
                ValidateButton("Confirm", onClick = {
                    onConfirm(playerName)
                    onDismiss()
                })
            },
            dismissButton = {
                OutlineButton("Cancel", onClick = onDismiss)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ProjetAndroidTheme {
        PlayerNameModal(true) { }
    }
}