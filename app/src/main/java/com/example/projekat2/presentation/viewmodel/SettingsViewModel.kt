package com.example.projekat2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.projekat2.presentation.state.SettingsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<SettingsUiState>(SettingsUiState.Init)
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = SettingsUiState.Loading
        _uiState.value = SettingsUiState.Success(false)
    }

    fun toggleDarkMode(enabled: Boolean) {
        _uiState.value = SettingsUiState.Success(enabled)
    }
}
