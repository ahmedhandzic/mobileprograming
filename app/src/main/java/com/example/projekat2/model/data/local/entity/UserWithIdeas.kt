package com.example.projekat2.model.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithIdeas(
    @Embedded val user: UserEntity,
    @Relation(parentColumn = "id", entityColumn = "userId")
    val ideas: List<IdeaEntity>
)
