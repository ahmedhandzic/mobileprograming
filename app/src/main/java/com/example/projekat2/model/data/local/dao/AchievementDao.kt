package com.example.projekat2.model.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projekat2.model.data.local.entity.AchievementEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AchievementDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAchievement(achievement: AchievementEntity)

    @Query("SELECT * FROM achievements WHERE userId = :userId")
    fun getAchievementsByUser(userId: Int): Flow<List<AchievementEntity>>

    @Delete
    suspend fun deleteAchievement(achievement: AchievementEntity)
}
