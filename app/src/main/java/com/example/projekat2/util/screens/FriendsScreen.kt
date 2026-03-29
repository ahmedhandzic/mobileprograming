package com.example.projekat2.util.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class FriendIdea(val name: String, val idea: String)

@Composable
fun FriendsScreen() {
    val friendsList = listOf(
        FriendIdea("Tarik", "Nauči 10 riječi na španskom"),
        FriendIdea("Lejla", "Napiši priču o svemiru"),
        FriendIdea("Kenan", "Napravi plan treninga za sedmicu"),
        FriendIdea("Emina", "Nacrtaj portret kućnog ljubimca"),
        FriendIdea("Adnan", "Slušaj podcast o historiji Rima"),
        FriendIdea("Sara", "Spremi novo jelo od samo 5 sastojaka")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()

            .background(Color(0xFFFFEBEE))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Ideje Prijatelja",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB71C1C),
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(friendsList) { friend ->
                FriendCard(friend)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun FriendCard(friend: FriendIdea) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Red)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFB71C1C)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = friend.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = friend.idea,
                    color = Color(0xFFFFEBEE),
                    fontSize = 14.sp
                )
            }
        }
    }
}