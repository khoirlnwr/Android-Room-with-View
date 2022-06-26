package com.example.androidroomwithviewcodelabs.view_models

import androidx.lifecycle.*
import com.example.androidroomwithviewcodelabs.entity.Word
import com.example.androidroomwithviewcodelabs.repository.WordRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    // launch a new co-routine
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown viewModel class")
    }
}