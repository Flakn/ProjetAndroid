package com.example.projet_android.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projet_android.components.buttons.ValidateButton
import com.example.projet_android.components.cards.RoundedDarkCard
import com.example.projet_android.components.inputs.EmailInput
import com.example.projet_android.components.inputs.PasswordInput
import com.example.projet_android.components.titles.ActivityTitle
import com.example.projet_android.components.titles.CardTitle
import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun LoginScreen(navController: NavHostController, scaffoldPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(scaffoldPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActivityTitle("D&D Manager")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(scaffoldPadding),
        verticalArrangement = Arrangement.Center
    ) {
        RoundedDarkCard {
            CardTitle("Login")
            Spacer(modifier = Modifier.height(16.dp))

            EmailInput()
            Spacer(modifier = Modifier.height(16.dp))

            PasswordInput()
            Spacer(modifier = Modifier.height(16.dp))

            ValidateButton("Valider")
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(scaffoldPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {  },
            modifier = Modifier
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF6D4C41)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Register", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    ProjetAndroidTheme {
        LoginScreen(rememberNavController(), PaddingValues())
    }
}