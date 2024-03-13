package com.example.mygdprojtwo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnClick).setOnClickListener {
            displayText("Button Clicked!")
        }

        findViewById<Button>(R.id.btnClick).setOnLongClickListener {
            displayText("Long Button Clicked!")
            true
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    displayText("Action Down")
                    true
                }
                MotionEvent.ACTION_UP -> {
                    displayText("Action Up")
                    true
                }
                MotionEvent.ACTION_POINTER_DOWN -> {
                    displayText("Action Pointer Down")
                    true
                }
                else -> false
            }
        }

        val editText = findViewById<EditText>(R.id.editText)
        val textResult = findViewById<TextView>(R.id.textResult)
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                textResult.text = s.toString()
            }
        })
    }

    private fun displayText(text: String) {
        findViewById<TextView>(R.id.textResult).text = text
    }
}
