package com.example.androidroomwithviewcodelabs

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidroomwithviewcodelabs.adapter.WordListAdapter
import com.example.androidroomwithviewcodelabs.databinding.ActivityMainBinding
import com.example.androidroomwithviewcodelabs.view_models.WordViewModel
import com.example.androidroomwithviewcodelabs.application.WordsApplication
import com.example.androidroomwithviewcodelabs.entity.Word
import com.example.androidroomwithviewcodelabs.view_models.WordViewModelFactory

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }

    private val newWordActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)

        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)

        wordViewModel.allWords.observe(this, Observer {
            val adapter = WordListAdapter(it)
            binding?.recyclerView?.adapter = adapter
        })

        binding?.fab?.setOnClickListener {
            val intent = Intent(this, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
                val word = Word(it)
                wordViewModel.insert(word)
            }
        } else {
            Toast.makeText(this, R.string.empty_not_saved, Toast.LENGTH_SHORT).show()
        }
    }
}