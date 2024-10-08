package com.example.projet_android.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projet_android.ui.components.headers.MainHeader
import com.example.projet_android.ui.components.buttons.ValidateButton
import com.example.projet_android.ui.components.cards.RoundedDarkCard
import com.example.projet_android.ui.components.inputs.EmailInput
import com.example.projet_android.ui.components.inputs.PasswordInput
import com.example.projet_android.ui.components.titles.CardTitle
import com.example.projet_android.navigation.Screen
import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun RegisterScreen(navController: NavHostController, scaffoldPadding: PaddingValues) {
    MainHeader(scaffoldPadding)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(scaffoldPadding),
        verticalArrangement = Arrangement.Center
    ) {
        RoundedDarkCard {
            CardTitle("Register")
            Spacer(modifier = Modifier.height(16.dp))

            EmailInput()
            Spacer(modifier = Modifier.height(16.dp))

            PasswordInput()
            Spacer(modifier = Modifier.height(16.dp))

            ValidateButton("Submit")
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(scaffoldPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        ValidateButton(text = "Login", color = Color(0xFF6D4C41), onClick = {
            navController.navigate(Screen.Login.route)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    ProjetAndroidTheme {
        RegisterScreen(rememberNavController(), PaddingValues())
    }
}