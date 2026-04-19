package com.example.projekat2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.projekat2.model.FriendIdea
import com.example.projekat2.model.hardcodedFriendsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FriendsViewModel : ViewModel() {

    private val _friendsState = MutableStateFlow(hardcodedFriendsList)
    val friendsState: StateFlow<List<FriendIdea>> = _friendsState.asStateFlow()
}