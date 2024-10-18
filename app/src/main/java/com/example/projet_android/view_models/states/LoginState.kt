package com.example.projet_android.view_models.states

sealed class LoginState {
    data class Success(val token: String) : LoginState()
    data class Error(val message: String) : LoginState()
}