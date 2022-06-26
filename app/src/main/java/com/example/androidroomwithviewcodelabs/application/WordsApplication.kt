package com.example.androidroomwithviewcodelabs.application

import android.app.Application
import com.example.androidroomwithviewcodelabs.database.WordRoomDatabase
import com.example.androidroomwithviewcodelabs.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {
        WordRoomDatabase.getDatabase(this, applicationScope)
    }

    val repository by lazy {
        WordRepository(database.wordDao())
    }
}