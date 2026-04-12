package com.example.projekat2.util.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.projekat2.R
import com.example.projekat2.util.components.QuestItem
import com.example.projekat2.util.QuestData

@Composable
fun QuestsScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Text(
                text = stringResource(R.string.quests),
                color = Color(0xFFB71C1C),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

            val quests = listOf(
                QuestData(id = 1, title = "Study Kotlin", xp = 20, isCompleted = false),
                QuestData(id = 2, title = "Workout", xp = 15, isCompleted = true),
                QuestData(id = 3, title = "Drink Water", xp = 10, isCompleted = false),
                QuestData(id = 4, title = "Read 10 Pages", xp = 25, isCompleted = false)
            )

            quests.forEach { quest ->
                QuestItem(quest = quest)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_xmedium)))
            }
        }

        FloatingActionButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(dimensionResource(R.dimen.padding_medium)),
            containerColor = Color(0xFFB71C1C)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(R.string.add_quest),
                tint = Color.White
            )
        }
    }
}

@Composable
fun DeleteQuestDialog(questTitle: String) {
    AlertDialog(
        onDismissRequest = { },
        title = { Text(text = "Delete Quest?", color = Color.White) },
        text = { Text(text = "Are you sure you want to remove \"$questTitle\"?", color = Color.White) },
        confirmButton = {
            TextButton(onClick = { }) {
                Text("Delete", color = Color.White)
            }
        },
        dismissButton = {
            TextButton(onClick = { }) {
                Text("Cancel", color = Color.White)
            }
        },
        containerColor = Color(0xFFB71C1C)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuestsScreenPreview() {
    MaterialTheme {
        QuestsScreen()
    }
}