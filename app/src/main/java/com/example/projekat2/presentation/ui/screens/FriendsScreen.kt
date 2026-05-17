package com.example.projekat2.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.projekat2.model.FriendIdea
import com.example.projekat2.presentation.navigation.Screen
import com.example.projekat2.presentation.state.FriendsUiState
import com.example.projekat2.presentation.ui.screens.friends.components.FriendCard
import com.example.projekat2.presentation.viewmodel.FriendsViewModel

@Composable
fun FriendsScreen(
    navController: NavController,
    viewModel: FriendsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val filteredFriends by viewModel.filteredFriends.collectAsState()

    val effectiveUiState = when (uiState) {
        is FriendsUiState.Success -> FriendsUiState.Success(filteredFriends)
        else -> uiState
    }

    FriendsScreenContent(
        uiState = effectiveUiState,
        searchQuery = searchQuery,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        onFriendClick = { friend ->
            navController.navigate(Screen.Details.createRoute(friend.id, friend.name))
        }
    )
}

@Composable
fun FriendsScreenContent(
    uiState: FriendsUiState,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onFriendClick: (FriendIdea) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBEE))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ideje Prijatelja",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB71C1C),
            modifier = Modifier.padding(16.dp)
        )

        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            label = { Text("Pretraga", color = Color(0xFFB71C1C)) },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFB71C1C),
                unfocusedBorderColor = Color.Red,
                cursorColor = Color(0xFFB71C1C),
                focusedLabelColor = Color(0xFFB71C1C),
                unfocusedLabelColor = Color.Red
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        when (uiState) {
            FriendsUiState.Init, FriendsUiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = Color(0xFFB71C1C))
                }
            }
            is FriendsUiState.Error -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = uiState.message, color = Color(0xFFB71C1C))
                }
            }
            is FriendsUiState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    if (uiState.friends.isEmpty()) {
                        item {
                            Text(
                                "No items available",
                                color = Color.Gray,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    } else {
                        items(uiState.friends) { friend ->
                            FriendCard(friend = friend, onClick = { onFriendClick(friend) })
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                }
            }
        }
    }
}
