package com.example.projekat2.util.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.example.projekat2.util.components.*

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()

            .background(Color(0xFFFFEBEE))
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(title = "IdeaGen")

        UserSectionCard(levelNo = 3, achievementLevel = "Kreativac", currentXP = 120, maxXP = 200)

        Spacer(modifier = Modifier.height(16.dp))

        InfoSection(
            title = "Današnje Ideje",
            rows = listOf(
                InfoRowData(title = "Aplikacija za vodu", imageVector = Icons.Default.Star),
                InfoRowData(title = "Jelo od 5 sastojaka", imageVector = Icons.Default.Star),
                InfoRowData(title = "Dizajniraj logo", imageVector = Icons.Default.Star)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        InfoSection(
            title = "Dostignuća",
            rows = listOf(
                InfoRowData(title = "Prva Ideja", imageVector = Icons.Default.Face),
                InfoRowData(title = "Niz od 3 Dana", imageVector = Icons.Default.Face)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

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