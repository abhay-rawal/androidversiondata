package com.example.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.lesson3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener{
            val newRow = TableRow(this)

            val versionTextView = TextView(this).apply {
                text = binding.androidVersion.text.toString()
                layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
                setBackgroundColor(ContextCompat.getColor(context, R.color.pink))
            }

            val codeNameTextView = TextView(this).apply {
                text = binding.codeName.text.toString()
                layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
                setBackgroundColor(ContextCompat.getColor(context, R.color.pink))
            }

            newRow.addView(versionTextView)
            newRow.addView(codeNameTextView)

            val divider = View(this).apply {
                layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1)
                setBackgroundColor(ContextCompat.getColor(context, R.color.dividerColor)) // Set your desired color for the divider line
            }

            newRow.addView(divider)
            binding.androidMain.addView(newRow)

            // Clear the EditText fields for next input
            binding.androidVersion.text.clear()
            binding.codeName.text.clear()

        }

    }
}