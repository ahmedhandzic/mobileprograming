package com.example.projekat2.model.repository

import com.example.projekat2.model.data.local.entity.IdeaEntity
import kotlinx.coroutines.flow.Flow

interface IdeaRepository {
    fun getAllIdeas(): Flow<List<IdeaEntity>>
    suspend fun insertIdea(idea: IdeaEntity)
    suspend fun deleteIdea(idea: IdeaEntity)
    fun getIdeasByUser(userId: Int): Flow<List<IdeaEntity>>
}
