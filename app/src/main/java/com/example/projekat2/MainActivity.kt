package com.example.projekat2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.projekat2.util.screens.LeaderboardScreen
import com.example.projekat2.util.screens.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LeaderboardScreen()
        }
    }
}