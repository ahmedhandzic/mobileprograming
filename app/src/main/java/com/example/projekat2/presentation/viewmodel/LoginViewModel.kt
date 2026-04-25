package com.example.projekat2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.projekat2.presentation.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(LoginState())
    val uiState = _uiState.asStateFlow()

    fun onUsernameChange(newName: String) {
        _uiState.value = _uiState.value.copy(username = newName)
    }
}