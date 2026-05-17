package com.example.projekat2.model.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.projekat2.model.data.local.entity.LeaderboardEntryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LeaderboardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(entry: LeaderboardEntryEntity)

    @Query("SELECT * FROM leaderboard_entries")
    fun getAllEntries(): Flow<List<LeaderboardEntryEntity>>

    @Update
    suspend fun updateEntry(entry: LeaderboardEntryEntity)

    @Delete
    suspend fun deleteEntry(entry: LeaderboardEntryEntity)
}
