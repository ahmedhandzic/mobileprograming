package com.example.projekat2.model.repository.mappers

import com.example.projekat2.model.data.local.entity.LeaderboardEntryEntity
import com.example.projekat2.presentation.ui.screens.leaderboard.components.LeaderboardPlayer

fun LeaderboardEntryEntity.toModel(): LeaderboardPlayer = LeaderboardPlayer(
    name = name,
    xp = xp
)

fun LeaderboardPlayer.toEntity(): LeaderboardEntryEntity = LeaderboardEntryEntity(
    name = name,
    xp = xp
)
