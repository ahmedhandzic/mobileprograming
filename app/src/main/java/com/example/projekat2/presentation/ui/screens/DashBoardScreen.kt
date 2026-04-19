package com.example.projekat2.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projekat2.presentation.ui.components.InfoRowData
import com.example.projekat2.presentation.ui.components.InfoSection
import com.example.projekat2.presentation.ui.components.Title
import com.example.projekat2.presentation.ui.components.UserSectionCard

@Composable
fun DashboardScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBEE))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Title(title = "IdeaGen")
            UserSectionCard(levelNo = 3, achievementLevel = "Kreativac", currentXP = 120, maxXP = 200)
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Današnje Ideje", fontWeight = FontWeight.Bold, color = Color(0xFFB71C1C), modifier = Modifier.padding(bottom = 8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    val ideje = listOf("Aplikacija za vodu", "Jelo od 5 sastojaka", "Dizajniraj logo")
                    items(ideje) { ideja ->
                        Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
                            Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFB71C1C))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = ideja, color = Color.Black)
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Dostignuća", fontWeight = FontWeight.Bold, color = Color(0xFFB71C1C), modifier = Modifier.padding(bottom = 8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    val dostignuca = listOf("Prva Ideja", "Niz od 3 Dana", "Ideja Master")
                    items(dostignuca) { dos ->
                        Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
                            Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Face, contentDescription = null, tint = Color(0xFFB71C1C))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = dos, color = Color.Black)
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            InfoSection(
                title = "Brza Statistika",
                rows = listOf(
                    InfoRowData(title = "Generisano ideja", additionalInfo = "5"),
                    InfoRowData(title = "Ukupno bodova", additionalInfo = "120"),
                    InfoRowData(title = "Dostignuća", additionalInfo = "3")
                )
            )
        }
    }
}