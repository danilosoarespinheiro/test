package com.example.questionFour


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StringsAdapter(private var words: ArrayList<String>) :
    RecyclerView.Adapter<StringsAdapter.ViewHolder>() {

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder( holder: ViewHolder, position: Int ) {
        holder.textViewName.text = words[position]
    }

    override fun getItemCount(): Int {
        return words.size
    }

    fun filterList(filteredWords: ArrayList<String>) {
        this.words = filteredWords
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName: TextView = itemView.findViewById(R.id.textview_word)
    }

}
