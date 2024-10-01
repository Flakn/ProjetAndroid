package com.example.projet_android.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Login : Screen("login")
    data object SignUp : Screen("sign_up")
}
