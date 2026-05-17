package com.example.projekat2.presentation.state

import com.example.projekat2.model.FriendIdea
import com.example.projekat2.presentation.ui.screens.leaderboard.components.LeaderboardPlayer

sealed class FriendsUiState {
    object Init : FriendsUiState()
    object Loading : FriendsUiState()
    data class Success(val friends: List<FriendIdea>) : FriendsUiState()
    data class Error(val message: String) : FriendsUiState()
}

sealed class DashboardUiState {
    object Init : DashboardUiState()
    object Loading : DashboardUiState()
    data class Success(val ideaCount: Int) : DashboardUiState()
    data class Error(val message: String) : DashboardUiState()
}

sealed class LeaderboardUiState {
    object Init : LeaderboardUiState()
    object Loading : LeaderboardUiState()
    data class Success(val players: List<LeaderboardPlayer>) : LeaderboardUiState()
    data class Error(val message: String) : LeaderboardUiState()
}

sealed class LoginUiState {
    object Init : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val email: String) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}

sealed class SettingsUiState {
    object Init : SettingsUiState()
    object Loading : SettingsUiState()
    data class Success(val isDarkMode: Boolean) : SettingsUiState()
    data class Error(val message: String) : SettingsUiState()
}
