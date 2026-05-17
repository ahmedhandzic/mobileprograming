package com.example.projekat2.model.repository

import com.example.projekat2.model.data.local.dao.LeaderboardDao
import com.example.projekat2.model.data.local.entity.LeaderboardEntryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LeaderboardRepositoryImpl @Inject constructor(
    private val leaderboardDao: LeaderboardDao
) : LeaderboardRepository {
    override fun getAllEntries(): Flow<List<LeaderboardEntryEntity>> = leaderboardDao.getAllEntries()

    override suspend fun insertEntry(entry: LeaderboardEntryEntity) = leaderboardDao.insertEntry(entry)

    override suspend fun updateEntry(entry: LeaderboardEntryEntity) = leaderboardDao.updateEntry(entry)

    override suspend fun deleteEntry(entry: LeaderboardEntryEntity) = leaderboardDao.deleteEntry(entry)
}
