package com.example.projekat2.model.repository

import com.example.projekat2.model.data.local.entity.LeaderboardEntryEntity
import kotlinx.coroutines.flow.Flow

interface LeaderboardRepository {
    fun getAllEntries(): Flow<List<LeaderboardEntryEntity>>
    suspend fun insertEntry(entry: LeaderboardEntryEntity)
    suspend fun updateEntry(entry: LeaderboardEntryEntity)
    suspend fun deleteEntry(entry: LeaderboardEntryEntity)
}
