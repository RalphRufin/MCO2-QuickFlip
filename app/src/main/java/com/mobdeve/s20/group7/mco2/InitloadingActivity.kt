package com.mobdeve.s20.group7.mco2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class InitloadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initload)


        val getStartedButton = findViewById<Button>(R.id.getStartedButton)

        val logInLinkTextView = findViewById<TextView>(R.id.logInLinkTextView)


        getStartedButton.setOnClickListener {

        }


        logInLinkTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
