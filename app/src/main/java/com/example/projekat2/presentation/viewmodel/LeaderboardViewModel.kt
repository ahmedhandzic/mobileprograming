package com.example.projekat2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projekat2.model.repository.LeaderboardRepository
import com.example.projekat2.model.repository.mappers.toModel
import com.example.projekat2.presentation.state.LeaderboardUiState
import com.example.projekat2.presentation.ui.screens.leaderboard.components.LeaderboardPlayer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeaderboardViewModel @Inject constructor(
    private val repository: LeaderboardRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<LeaderboardUiState>(LeaderboardUiState.Init)
    val uiState: StateFlow<LeaderboardUiState> = _uiState.asStateFlow()

    private val playersFlow: StateFlow<List<LeaderboardPlayer>> = _uiState
        .map { state ->
            if (state is LeaderboardUiState.Success) state.players else emptyList()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    val rankedPlayers: StateFlow<List<LeaderboardPlayer>> = playersFlow
        .map { list -> list.sortedByDescending { it.xp } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    val topPlayer: StateFlow<LeaderboardPlayer?> = playersFlow
        .map { list -> list.maxByOrNull { it.xp } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    val totalXP: StateFlow<Int> = playersFlow
        .map { list -> list.sumOf { it.xp } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = 0
        )

    init {
        _uiState.value = LeaderboardUiState.Loading
        viewModelScope.launch {
            try {
                repository.getAllEntries()
                    .map { entities -> entities.map { it.toModel() } }
                    .collect { list ->
                        _uiState.value = LeaderboardUiState.Success(list)
                    }
            } catch (e: Exception) {
                _uiState.value = LeaderboardUiState.Error(e.message ?: "Greška")
            }
        }
    }
}
