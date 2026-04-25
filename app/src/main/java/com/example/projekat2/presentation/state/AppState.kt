package com.example.projekat2.presentation.state

data class LoginState(val username: String = "", val isLoginSuccess: Boolean = false)
data class DashboardState(val totalScore: Int = 0, val activities: List<String> = emptyList())
data class FriendsState(val friends: List<String> = emptyList())
data class LeaderboardState(val entries: List<String> = emptyList())
data class SettingsState(val isDarkMode: Boolean = false)