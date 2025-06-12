package com.example.travelchecklistapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        listView = findViewById(R.id.summary_list_view)
        backButton = findViewById(R.id.back_button)

        val items = intent.getStringArrayListExtra("items") ?: arrayListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        backButton.setOnClickListener {
            finish()
        }
    }
}
