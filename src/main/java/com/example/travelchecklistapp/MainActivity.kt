package com.example.travelchecklistapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var itemInput: EditText
    private lateinit var addButton: Button
    private lateinit var clearButton: Button
    private lateinit var viewSummaryButton: Button
    private lateinit var listView: ListView

    private val itemList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemInput = findViewById(R.id.item_input)
        addButton = findViewById(R.id.add_button)
        clearButton = findViewById(R.id.clear_button)
        viewSummaryButton = findViewById(R.id.view_summary_button)
        listView = findViewById(R.id.item_list)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = adapter

        addButton.setOnClickListener {
            val item = itemInput.text.toString().trim()
            if (item.isNotEmpty()) {
                itemList.add(item)
                adapter.notifyDataSetChanged()
                itemInput.text.clear()
            } else {
                Toast.makeText(this, "Please enter an item.", Toast.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnClickListener {
            itemList.clear()
            adapter.notifyDataSetChanged()
        }

        viewSummaryButton.setOnClickListener {
            val intent = Intent(this, SummaryActivity::class.java)
            intent.putStringArrayListExtra("items", itemList)
            startActivity(intent)
        }
    }
}
