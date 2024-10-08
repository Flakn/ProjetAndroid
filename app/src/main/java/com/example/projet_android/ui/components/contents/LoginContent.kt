package com.example.projet_android.ui.components.contents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projet_android.navigation.Screen
import com.example.projet_android.ui.components.buttons.ValidateButton
import com.example.projet_android.ui.components.cards.RoundedDarkCard
import com.example.projet_android.ui.components.inputs.EmailInput
import com.example.projet_android.ui.components.inputs.PasswordInput
import com.example.projet_android.ui.components.titles.CardTitle
import com.example.projet_android.ui.theme.ProjetAndroidTheme

@Composable
fun LoginContent(scaffoldPadding: PaddingValues, cardTitle: String, navController: NavHostController, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(scaffoldPadding),
        verticalArrangement = Arrangement.Center
    ) {
        RoundedDarkCard {
            CardTitle(cardTitle)
            Spacer(modifier = Modifier.height(16.dp))

            EmailInput()
            Spacer(modifier = Modifier.height(16.dp))

            PasswordInput()
            Spacer(modifier = Modifier.height(16.dp))

            ValidateButton("Submit", onClick = {
                navController.navigate(Screen.Home.route)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ProjetAndroidTheme {
        LoginContent(PaddingValues(), "Login", rememberNavController())
    }
}