package com.example.androidroomwithviewcodelabs.application

import android.app.Application
import com.example.androidroomwithviewcodelabs.database.WordRoomDatabase
import com.example.androidroomwithviewcodelabs.repository.WordRepository

class WordsApplication : Application() {
    val database by lazy {
        WordRoomDatabase.getDatabase(this)
    }


    val repository by lazy {
        WordRepository(database.wordDao())
    }
}