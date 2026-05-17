package com.example.projekat2.model.repository.mappers

import com.example.projekat2.model.FriendIdea
import com.example.projekat2.model.data.local.entity.FriendEntity

fun FriendEntity.toModel(): FriendIdea = FriendIdea(
    id = id,
    name = name,
    idea = idea
)

fun FriendIdea.toEntity(): FriendEntity = FriendEntity(
    id = id,
    name = name,
    idea = idea
)
