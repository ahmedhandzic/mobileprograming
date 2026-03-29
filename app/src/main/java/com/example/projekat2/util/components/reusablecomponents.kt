package com.example.projekat2.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


val AliceBlue = Color.White
val RosyTaupe = Color(0xFFFFCDD2)
val DustyOlive = Color(0xFFD32F2F)
val DeepTeal = Color.Red

data class InfoRowData(
    val title: String,
    val additionalInfo: String? = null,
    val imageVector: ImageVector? = null
)

@Composable
fun Title(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun UserSectionCard(levelNo: Int, achievementLevel: String, currentXP: Int, maxXP: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = DustyOlive)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(64.dp).clip(CircleShape).background(AliceBlue),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null, modifier = Modifier.size(36.dp), tint = DeepTeal)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "Level $levelNo $achievementLevel", style = MaterialTheme.typography.titleMedium, color = AliceBlue)
                    Text(text = "Ideje: $currentXP / $maxXP", style = MaterialTheme.typography.bodyMedium, color = AliceBlue)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(
                progress = currentXP.toFloat() / maxXP.toFloat(),
                modifier = Modifier.fillMaxWidth().height(8.dp),
                color = AliceBlue, trackColor = RosyTaupe
            )
        }
    }
}

@Composable
fun InfoRow(title: String, modifier: Modifier = Modifier, imageVector: ImageVector? = null, additionalInfo: String? = null) {
    Row(
        modifier = modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (additionalInfo != null && imageVector == null) Arrangement.SpaceBetween else Arrangement.Start
    ) {
        if (imageVector != null) {
            Icon(imageVector = imageVector, contentDescription = null, modifier = Modifier.size(20.dp), tint = RosyTaupe)
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(text = title, style = MaterialTheme.typography.bodyLarge, color = AliceBlue)
        if (additionalInfo != null && imageVector == null) {
            Text(text = additionalInfo, style = MaterialTheme.typography.bodyLarge, color = RosyTaupe)
        }
    }
}

@Composable
fun InfoSection(title: String, rows: List<InfoRowData>, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = DeepTeal)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleMedium, color = AliceBlue)
            Spacer(modifier = Modifier.height(8.dp))
            rows.forEach { rowData ->
                InfoRow(title = rowData.title, imageVector = rowData.imageVector, additionalInfo = rowData.additionalInfo)
            }
        }
    }
}