package com.example.projekat2.model

data class FriendIdea(
    val id: Int,
    val name: String,
    val idea: String
)

val hardcodedFriendsList = listOf(
    FriendIdea(1, "Tarik", "Nauči 10 riječi na španskom"),
    FriendIdea(2, "Lejla", "Napiši priču o svemiru"),
    FriendIdea(3, "Kenan", "Napravi plan treninga za sedmicu"),
    FriendIdea(4, "Emina", "Nacrtaj portret kućnog ljubimca"),
    FriendIdea(5, "Adnan", "Slušaj podcast o historiji Rima"),
    FriendIdea(6, "Sara", "Spremi novo jelo od samo 5 sastojaka")
)