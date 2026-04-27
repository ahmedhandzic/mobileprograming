package com.example.projekat2.presentation.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object Friends : Screen("friends")
    object Leaderboard : Screen("leaderboard")
    object Settings : Screen("settings")


    object Details : Screen("details/{itemId}/{itemName}") {
        fun createRoute(itemId: Int, itemName: String) = "details/$itemId/$itemName"
    }
}