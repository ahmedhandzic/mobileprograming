package com.example.projekat2

import android.app.Application
import com.example.projekat2.model.data.local.db.AppDatabase
import com.example.projekat2.model.data.local.util.DatabasePopulator
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

@HiltAndroidApp
class IdeaGenApp : Application() {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface DatabaseEntryPoint {
        fun appDatabase(): AppDatabase
    }

    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        val entryPoint = EntryPointAccessors.fromApplication(this, DatabaseEntryPoint::class.java)
        val db = entryPoint.appDatabase()
        applicationScope.launch {
            DatabasePopulator.populateIfEmpty(db)
        }
    }
}
