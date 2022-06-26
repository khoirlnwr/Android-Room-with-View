package com.example.androidroomwithviewcodelabs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidroomwithviewcodelabs.R
import com.example.androidroomwithviewcodelabs.entity.Word

class WordListAdapter(private val dataset: List<Word>) :
    RecyclerView.Adapter<WordListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView? = null

        init {
            textView = view.findViewById(R.id.textview)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView?.text = dataset[position].word
    }

    override fun getItemCount() = dataset.size


}