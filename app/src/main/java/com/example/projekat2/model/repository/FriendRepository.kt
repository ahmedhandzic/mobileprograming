package com.example.projekat2.model.repository

import com.example.projekat2.model.data.local.entity.FriendEntity
import kotlinx.coroutines.flow.Flow

interface FriendRepository {
    fun getAllFriends(): Flow<List<FriendEntity>>
    suspend fun insertFriend(friend: FriendEntity)
    suspend fun deleteFriend(friend: FriendEntity)
    suspend fun updateFriend(friend: FriendEntity)
}
