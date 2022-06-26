package com.example.androidroomwithviewcodelabs.repository

import androidx.annotation.WorkerThread
import com.example.androidroomwithviewcodelabs.dao.WordDao
import com.example.androidroomwithviewcodelabs.entity.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    // Room exec all queries in separated thread
    // Observed flow will notify the observer when data has changed
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}