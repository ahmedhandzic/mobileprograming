package com.example.projekat2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projekat2.model.repository.IdeaRepository
import com.example.projekat2.presentation.state.DashboardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashBoardViewModel @Inject constructor(
    private val repository: IdeaRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Init)
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    private val _totalIdeas = MutableStateFlow(5)
    val totalIdeas: StateFlow<Int> = _totalIdeas.asStateFlow()

    private val _totalPoints = MutableStateFlow(120)
    val totalPoints: StateFlow<Int> = _totalPoints.asStateFlow()

    private val _achievementCount = MutableStateFlow(3)
    val achievementCount: StateFlow<Int> = _achievementCount.asStateFlow()

    private val _dailyIdeas = MutableStateFlow(
        listOf("Aplikacija za vodu", "Jelo od 5 sastojaka", "Dizajniraj logo")
    )
    val dailyIdeas: StateFlow<List<String>> = _dailyIdeas.asStateFlow()

    private val _achievements = MutableStateFlow(
        listOf("Prva Ideja", "Niz od 3 Dana", "Ideja Master")
    )
    val achievements: StateFlow<List<String>> = _achievements.asStateFlow()

    init {
        _uiState.value = DashboardUiState.Loading
        viewModelScope.launch {
            try {
                repository.getAllIdeas()
                    .map { it.size }
                    .collect { count ->
                        _uiState.value = DashboardUiState.Success(count)
                    }
            } catch (e: Exception) {
                _uiState.value = DashboardUiState.Error(e.message ?: "Greška")
            }
        }
    }
}
