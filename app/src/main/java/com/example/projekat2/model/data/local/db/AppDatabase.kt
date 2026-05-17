package com.example.projekat2.model.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projekat2.model.data.local.dao.AchievementDao
import com.example.projekat2.model.data.local.dao.FriendDao
import com.example.projekat2.model.data.local.dao.IdeaDao
import com.example.projekat2.model.data.local.dao.LeaderboardDao
import com.example.projekat2.model.data.local.dao.UserDao
import com.example.projekat2.model.data.local.entity.AchievementEntity
import com.example.projekat2.model.data.local.entity.FriendEntity
import com.example.projekat2.model.data.local.entity.IdeaEntity
import com.example.projekat2.model.data.local.entity.LeaderboardEntryEntity
import com.example.projekat2.model.data.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        IdeaEntity::class,
        AchievementEntity::class,
        FriendEntity::class,
        LeaderboardEntryEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun ideaDao(): IdeaDao
    abstract fun achievementDao(): AchievementDao
    abstract fun friendDao(): FriendDao
    abstract fun leaderboardDao(): LeaderboardDao
}
