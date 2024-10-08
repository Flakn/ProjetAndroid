package com.example.projet_android.ui.components.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ValidateButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier, color: Color = Color(0xFF00C853)){
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(color),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = text, color = Color.White)
    }
}
