package com.example.projekat2.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projekat2.presentation.state.LeaderboardUiState
import com.example.projekat2.presentation.ui.screens.leaderboard.components.LeaderboardCard
import com.example.projekat2.presentation.viewmodel.LeaderboardViewModel

@Composable
fun LeaderboardScreen(
    navController: NavController,
    viewModel: LeaderboardViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val rankedPlayers by viewModel.rankedPlayers.collectAsState()

    val effectiveUiState = when (uiState) {
        is LeaderboardUiState.Success -> LeaderboardUiState.Success(rankedPlayers)
        else -> uiState
    }

    LeaderboardScreenContent(uiState = effectiveUiState)
}

@Composable
fun LeaderboardScreenContent(uiState: LeaderboardUiState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBEE))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Tabela Najboljih",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB71C1C),
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        when (uiState) {
            LeaderboardUiState.Init, LeaderboardUiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = Color(0xFFB71C1C))
                }
            }
            is LeaderboardUiState.Error -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = uiState.message, color = Color(0xFFB71C1C))
                }
            }
            is LeaderboardUiState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    itemsIndexed(uiState.players) { index, player ->
                        val rank = index + 1
                        LeaderboardCard(rank = rank, player = player)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}
