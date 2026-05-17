package com.example.projekat2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projekat2.model.FriendIdea
import com.example.projekat2.model.repository.FriendRepository
import com.example.projekat2.model.repository.mappers.toModel
import com.example.projekat2.presentation.state.FriendsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FriendsViewModel @Inject constructor(
    private val repository: FriendRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<FriendsUiState>(FriendsUiState.Init)
    val uiState: StateFlow<FriendsUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val friendsFlow: StateFlow<List<FriendIdea>> = _uiState
        .map { state ->
            if (state is FriendsUiState.Success) state.friends else emptyList()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    val filteredFriends: StateFlow<List<FriendIdea>> =
        combine(friendsFlow, _searchQuery) { friends, query ->
            if (query.isBlank()) {
                friends
            } else {
                friends.filter {
                    it.name.contains(query, ignoreCase = true) ||
                            it.idea.contains(query, ignoreCase = true)
                }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    val friendCount: StateFlow<Int> = friendsFlow
        .map { it.size }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = 0
        )

    val hasResults: StateFlow<Boolean> = filteredFriends
        .map { it.isNotEmpty() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = false
        )

    val isEmpty: StateFlow<Boolean> = filteredFriends
        .map { it.isEmpty() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = true
        )

    init {
        _uiState.value = FriendsUiState.Loading
        viewModelScope.launch {
            try {
                repository.getAllFriends()
                    .map { entities -> entities.map { it.toModel() } }
                    .collect { list ->
                        _uiState.value = FriendsUiState.Success(list)
                    }
            } catch (e: Exception) {
                _uiState.value = FriendsUiState.Error(e.message ?: "Greška")
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }
}
