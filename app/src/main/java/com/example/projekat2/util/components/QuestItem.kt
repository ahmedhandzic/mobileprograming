package com.example.projekat2.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.projekat2.R
import com.example.projekat2.util.QuestData

@Composable
fun QuestItem(
    quest: QuestData,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimensionResource(R.dimen.size_small)))
            .background(Color(0xFFB71C1C)) // Tamno crvena boja kartice
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Checkbox(
                checked = quest.isCompleted,
                onCheckedChange = null,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color.White,
                    checkmarkColor = Color(0xFFB71C1C)
                )
            )

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.width_xmedium)))

            Column {
                Text(
                    text = quest.title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "+${quest.xp} XP",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }
        }

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(R.string.delete_quest),
                tint = Color.White
            )
        }
    }
}