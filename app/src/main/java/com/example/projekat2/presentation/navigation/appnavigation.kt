package com.example.projekat2.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projekat2.presentation.ui.screens.DashboardScreen
import com.example.projekat2.presentation.ui.screens.DetailsScreen
import com.example.projekat2.presentation.ui.screens.FriendsScreen
import com.example.projekat2.presentation.ui.screens.LeaderboardScreen
import com.example.projekat2.presentation.ui.screens.LoginScreen
import com.example.projekat2.presentation.ui.screens.SettingsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (currentRoute in listOf(Screen.Dashboard.route, Screen.Friends.route, Screen.Leaderboard.route, Screen.Settings.route)) {
                NavigationBar(containerColor = Color.White) {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = null) },
                        label = { Text("Početna") },
                        selected = currentRoute == Screen.Dashboard.route,
                        onClick = { navController.navigate(Screen.Dashboard.route) }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = null) },
                        label = { Text("Prijatelji") },
                        selected = currentRoute == Screen.Friends.route,
                        onClick = { navController.navigate(Screen.Friends.route) }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Star, contentDescription = null) },
                        label = { Text("Rank") },
                        selected = currentRoute == Screen.Leaderboard.route,
                        onClick = { navController.navigate(Screen.Leaderboard.route) }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                        label = { Text("Postavke") },
                        selected = currentRoute == Screen.Settings.route,
                        onClick = { navController.navigate(Screen.Settings.route) }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Login.route) { LoginScreen(navController) }
            composable(Screen.Dashboard.route) { DashboardScreen(navController) }
            composable(Screen.Friends.route) { FriendsScreen(navController) }
            composable(Screen.Leaderboard.route) { LeaderboardScreen(navController) }
            composable(Screen.Settings.route) { SettingsScreen(navController) }

            composable(
                route = Screen.Details.route,
                arguments = listOf(
                    navArgument("itemId") { type = NavType.IntType },
                    navArgument("itemName") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getInt("itemId") ?: 0
                val itemName = backStackEntry.arguments?.getString("itemName") ?: ""
                DetailsScreen(navController, itemId, itemName)
            }
        }
    }
}