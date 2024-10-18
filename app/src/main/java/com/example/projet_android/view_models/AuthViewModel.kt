package com.example.projet_android.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projet_android.navigation.PreferencesHelper
import com.example.projet_android.repositories.AuthRepository
import com.example.projet_android.view_models.states.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val preferencesHelper: PreferencesHelper
) : ViewModel() {

    private val _loginState = MutableLiveData<LoginState?>()
    val loginState: MutableLiveData<LoginState?> = _loginState

    fun register(username: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                authRepository.register(username, email, password)
                login(email, password)
            } catch (e: Exception) {
                e.printStackTrace()
                _loginState.postValue(LoginState.Error("Register failed"))
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val token = authRepository.login(email, password)
                preferencesHelper.saveToken(token)
                _loginState.postValue(LoginState.Success(token))
            } catch (e: Exception) {
                e.printStackTrace()
                _loginState.postValue(LoginState.Error("Login failed"))
            }
        }
    }

    fun isConnected(): Boolean {
        return preferencesHelper.getToken() != null
    }

    fun logout() {
        preferencesHelper.clearToken()
    }

    fun resetLoginState() {
        _loginState.value = null
    }
}
