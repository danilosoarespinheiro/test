package com.example.questionFour

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var wordsRecyclerView: RecyclerView? = null
    private var searchEditText: EditText? = null
    private lateinit var words: ArrayList<String>
    var stringsAdapter: StringsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateArray()

        wordsRecyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        searchEditText = findViewById<View>(R.id.search_edit_text) as EditText
        wordsRecyclerView!!.setHasFixedSize(true)
        wordsRecyclerView!!.layoutManager = LinearLayoutManager(this)
        stringsAdapter = StringsAdapter(words)

        wordsRecyclerView!!.adapter = stringsAdapter

        searchEditText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int ) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun afterTextChanged(editable: Editable) {
                filter(editable.toString())
            }
        })
    }

    private fun filter(word: String) {

        val filteredWords: ArrayList<String> = ArrayList()

        for (s  in this.words) {
            if ((s.toLowerCase().contains(word.toLowerCase())) || (verifyParcialPermutation(s, word)) ) {
                filteredWords.add(s)
            }
            
        }

        stringsAdapter?.filterList(filteredWords)
    }

    private fun populateArray() {
        words = ArrayList()
        words.add("you")
        words.add("probably")
        words.add("despite")
        words.add("moon")
        words.add("misspellings")
        words.add("pale")
        words.add("bale")
    }

    private fun verifyParcialPermutation(first : String, second : String) : Boolean {

        val firstSize: Int = first.length
        val secondSize: Int = second.length
        var countDifferentLetters = 0

        if (firstSize != secondSize) {
            return false
        }
        val firstArray: CharArray = first.toCharArray()
        val secondArray: CharArray = second.toCharArray()

        for (i in 0 until firstSize){
            if (firstArray[i] != secondArray[i]) {
                countDifferentLetters++
                if(countDifferentLetters == 4){
                    return false
                }
            }
        }

        return true
    }

}
