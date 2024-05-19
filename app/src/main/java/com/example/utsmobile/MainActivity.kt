package com.example.utsmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val email = findViewById<TextInputEditText>(R.id.textInputEditText2)
        val password = findViewById<TextInputEditText>(R.id.textInputEditText)
        val Login = findViewById<Button>(R.id.button)

        // Set up the login button click listener
        Login.setOnClickListener {
            // Get the email and password from the text fields
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            // Check if the email and password are correct
            if (emailText == "nauramufidah@gmail.com" && passwordText == "naura") {
                // Start the next activity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                // Show an error message
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}