package com.example.projekat2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.projekat2.presentation.state.LeaderboardState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LeaderboardViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(LeaderboardState())
    val uiState: StateFlow<LeaderboardState> = _uiState.asStateFlow()

    fun refreshLeaderboard() {
        _uiState.value = _uiState.value.copy(entries = listOf("User 1", "User 2", "User 3"))
    }
}