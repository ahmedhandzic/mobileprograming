package com.example.projekat2.model.di

import android.content.Context
import androidx.room.Room
import com.example.projekat2.model.data.local.dao.AchievementDao
import com.example.projekat2.model.data.local.dao.FriendDao
import com.example.projekat2.model.data.local.dao.IdeaDao
import com.example.projekat2.model.data.local.dao.LeaderboardDao
import com.example.projekat2.model.data.local.dao.UserDao
import com.example.projekat2.model.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "ideagen_db"
        ).build()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideIdeaDao(db: AppDatabase): IdeaDao = db.ideaDao()

    @Provides
    fun provideAchievementDao(db: AppDatabase): AchievementDao = db.achievementDao()

    @Provides
    fun provideFriendDao(db: AppDatabase): FriendDao = db.friendDao()

    @Provides
    fun provideLeaderboardDao(db: AppDatabase): LeaderboardDao = db.leaderboardDao()
}
