package com.example.projet_android.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projet_android.R
import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun ImageButton(imageId: Int, imageDescription: String, onClick: () -> Unit, modifier: Modifier = Modifier){
    Button(
        onClick = onClick,
        modifier = modifier
            .size(64.dp)
            .clip(CircleShape),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = imageDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImageButtonPreview() {
    ProjetAndroidTheme {
        ImageButton(R.drawable.user_icon, "Profile icon", onClick = { })
    }
}