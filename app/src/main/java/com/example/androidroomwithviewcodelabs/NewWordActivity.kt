package com.example.androidroomwithviewcodelabs

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.androidroomwithviewcodelabs.databinding.ActivityNewWordBinding

class NewWordActivity : AppCompatActivity() {

    private var binding: ActivityNewWordBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewWordBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)

        binding?.btnSave?.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(binding?.etWord?.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = binding?.etWord?.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.androidroomwithviewcodelabs"
    }
}