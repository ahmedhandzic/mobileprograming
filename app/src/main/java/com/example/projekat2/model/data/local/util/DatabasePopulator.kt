package com.example.projekat2.model.data.local.util

import com.example.projekat2.model.data.local.db.AppDatabase
import com.example.projekat2.model.data.local.entity.AchievementEntity
import com.example.projekat2.model.data.local.entity.FriendEntity
import com.example.projekat2.model.data.local.entity.IdeaEntity
import com.example.projekat2.model.data.local.entity.LeaderboardEntryEntity
import com.example.projekat2.model.data.local.entity.UserEntity
import kotlinx.coroutines.flow.first

object DatabasePopulator {
    suspend fun populateIfEmpty(db: AppDatabase) {
        val users = db.userDao().getAllUsers().first()
        if (users.isNotEmpty()) return

        db.userDao().insertUser(
            UserEntity(id = 1, name = "Ahmed", email = "ahmed@test.com", level = 3, xp = 120)
        )

        val ideas = listOf(
            IdeaEntity(title = "Aplikacija za vodu", description = "Aplikacija za vodu", userId = 1),
            IdeaEntity(title = "Jelo od 5 sastojaka", description = "Jelo od 5 sastojaka", userId = 1),
            IdeaEntity(title = "Dizajniraj logo", description = "Dizajniraj logo", userId = 1)
        )
        ideas.forEach { db.ideaDao().insertIdea(it) }

        val achievements = listOf(
            AchievementEntity(title = "Prva Ideja", userId = 1),
            AchievementEntity(title = "Niz od 3 Dana", userId = 1),
            AchievementEntity(title = "Ideja Master", userId = 1)
        )
        achievements.forEach { db.achievementDao().insertAchievement(it) }

        val friends = listOf(
            FriendEntity(name = "Tarik", idea = "Nauči 10 riječi na španskom"),
            FriendEntity(name = "Lejla", idea = "Napiši priču o svemiru"),
            FriendEntity(name = "Kenan", idea = "Napravi plan treninga za sedmicu"),
            FriendEntity(name = "Emina", idea = "Nacrtaj portret kućnog ljubimca"),
            FriendEntity(name = "Adnan", idea = "Slušaj podcast o historiji Rima"),
            FriendEntity(name = "Sara", idea = "Spremi novo jelo od samo 5 sastojaka")
        )
        friends.forEach { db.friendDao().insertFriend(it) }

        val players = listOf(
            LeaderboardEntryEntity(name = "Tarik", xp = 540),
            LeaderboardEntryEntity(name = "Lejla", xp = 480),
            LeaderboardEntryEntity(name = "Ja", xp = 320),
            LeaderboardEntryEntity(name = "Kenan", xp = 290),
            LeaderboardEntryEntity(name = "Emina", xp = 150),
            LeaderboardEntryEntity(name = "Adnan", xp = 90)
        )
        players.forEach { db.leaderboardDao().insertEntry(it) }
    }
}
