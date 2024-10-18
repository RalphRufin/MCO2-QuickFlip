package com.mobdeve.s20.group7.mco2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signUpClickText = findViewById<TextView>(R.id.signUpText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val emailField = findViewById<EditText>(R.id.emailEditText)
        val passwordField = findViewById<EditText>(R.id.passwordEditText                         )

        // Handle "Sign Up" click to go to the SignupActivity
        signUpClickText.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }


        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (isValidLogin(email, password)) {
                // Successful login, redirect to BrowseActivity
                val intent = Intent(this, BrowseActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Failed login, show a toast or error message
                Toast.makeText(this, "Invalid login credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Placeholder function for login validation logic using dummy data
    private fun isValidLogin(email: String, password: String): Boolean {
        // Dummy credentials
        val dummyEmail = "dummyuser@example.com"
        val dummyPassword = "password123"

        return email == dummyEmail && password == dummyPassword
    }
}
