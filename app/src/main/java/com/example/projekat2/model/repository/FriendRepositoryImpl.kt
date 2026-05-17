package com.example.projekat2.model.repository

import com.example.projekat2.model.data.local.dao.FriendDao
import com.example.projekat2.model.data.local.entity.FriendEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FriendRepositoryImpl @Inject constructor(
    private val friendDao: FriendDao
) : FriendRepository {
    override fun getAllFriends(): Flow<List<FriendEntity>> = friendDao.getAllFriends()

    override suspend fun insertFriend(friend: FriendEntity) = friendDao.insertFriend(friend)

    override suspend fun deleteFriend(friend: FriendEntity) = friendDao.deleteFriend(friend)

    override suspend fun updateFriend(friend: FriendEntity) = friendDao.updateFriend(friend)
}
