package com.example.exp03_d12a07

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView = findViewById<TextView>(R.id.txtSecond)

        val name = intent.getStringExtra("USERNAME")

        if (name != null) {
            textView.text = "Welcome $name"
        }
    }
}