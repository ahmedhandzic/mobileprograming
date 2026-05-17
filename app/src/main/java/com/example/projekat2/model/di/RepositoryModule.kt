package com.example.projekat2.model.di

import com.example.projekat2.model.repository.FriendRepository
import com.example.projekat2.model.repository.FriendRepositoryImpl
import com.example.projekat2.model.repository.IdeaRepository
import com.example.projekat2.model.repository.IdeaRepositoryImpl
import com.example.projekat2.model.repository.LeaderboardRepository
import com.example.projekat2.model.repository.LeaderboardRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindIdeaRepository(impl: IdeaRepositoryImpl): IdeaRepository

    @Binds
    @Singleton
    abstract fun bindFriendRepository(impl: FriendRepositoryImpl): FriendRepository

    @Binds
    @Singleton
    abstract fun bindLeaderboardRepository(impl: LeaderboardRepositoryImpl): LeaderboardRepository
}
