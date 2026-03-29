package com.example.projekat2.util.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class LeaderboardPlayer(val name: String, val xp: Int)

@Composable
fun LeaderboardScreen() {
    val players = listOf(
        LeaderboardPlayer("Tarik", 540),
        LeaderboardPlayer("Lejla", 480),
        LeaderboardPlayer("Ja", 320),
        LeaderboardPlayer("Kenan", 290),
        LeaderboardPlayer("Emina", 150),
        LeaderboardPlayer("Adnan", 90)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBEE))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Tabela Najboljih",
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
            itemsIndexed(players) { index, player ->
                val rank = index + 1
                LeaderboardCard(rank = rank, player = player)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}


@Composable
fun LeaderboardCard(rank: Int, player: LeaderboardPlayer) {
    val isMe = player.name == "Ti (Ja)"
    val cardColor = if (isMe) Color(0xFFB71C1C) else Color.Red

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (rank <= 3) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Top 3",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(32.dp)
                )
            } else {
                Text(
                    text = "#$rank",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.width(32.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = player.name,
                color = Color.White,
                fontWeight = if (isMe) FontWeight.ExtraBold else FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.weight(1f)
            )


            Text(
                text = "${player.xp} XP",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}