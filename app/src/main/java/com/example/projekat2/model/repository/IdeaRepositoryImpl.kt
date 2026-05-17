package com.example.projekat2.model.repository

import com.example.projekat2.model.data.local.dao.IdeaDao
import com.example.projekat2.model.data.local.entity.IdeaEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IdeaRepositoryImpl @Inject constructor(
    private val ideaDao: IdeaDao
) : IdeaRepository {
    override fun getAllIdeas(): Flow<List<IdeaEntity>> = ideaDao.getAllIdeas()

    override suspend fun insertIdea(idea: IdeaEntity) = ideaDao.insertIdea(idea)

    override suspend fun deleteIdea(idea: IdeaEntity) = ideaDao.deleteIdea(idea)

    override fun getIdeasByUser(userId: Int): Flow<List<IdeaEntity>> = ideaDao.getIdeasByUser(userId)
}
