package com.example.androidroomwithviewcodelabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidroomwithviewcodelabs.adapter.WordListAdapter
import com.example.androidroomwithviewcodelabs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)

        // val adapter = WordListAdapter()
        // binding?.recyclerView
    }
}