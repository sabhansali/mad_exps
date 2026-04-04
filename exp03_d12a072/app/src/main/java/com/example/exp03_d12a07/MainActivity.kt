package com.example.exp03_d12a07

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Button reference
        val btnExplicitNoData = findViewById<Button>(R.id.btnExplicitNoData)

        btnExplicitNoData.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }

        val btnExplicitWithData = findViewById<Button>(R.id.btnExplicitWithData)

        btnExplicitWithData.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USERNAME", "Student S")
            startActivity(intent)

            Toast.makeText(this, "Opening with Data", Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBrowser = findViewById<Button>(R.id.btnBrowser)
        val btnDial = findViewById<Button>(R.id.btnDial)

        btnBrowser.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = android.net.Uri.parse("https://www.google.com")
            startActivity(intent)

            Toast.makeText(this, "Opening Browser", Toast.LENGTH_SHORT).show()
        }

        btnDial.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = android.net.Uri.parse("tel:1234567890")
            startActivity(intent)

            Toast.makeText(this, "Opening Dialer", Toast.LENGTH_SHORT).show()
        }

        val btnFrag1 = findViewById<Button>(R.id.btnFrag1)
        val btnFrag2 = findViewById<Button>(R.id.btnFrag2)

        btnFrag1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentOne())
                .addToBackStack(null)
                .commit()

            Toast.makeText(this, "Fragment One Loaded", Toast.LENGTH_SHORT).show()
        }

        btnFrag2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentTwo())
                .addToBackStack(null)
                .commit()

            Toast.makeText(this, "Fragment Two Loaded", Toast.LENGTH_SHORT).show()
        }
    }
}
