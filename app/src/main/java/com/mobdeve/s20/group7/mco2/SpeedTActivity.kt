package com.mobdeve.s20.group7.mco2

import android.os.Bundle
import android.widget.TextView
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class SpeedTActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speedt)

        // Get the references to the UI elements
        val flipCard = findViewById<FrameLayout>(R.id.flipCard)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val tvAnswer = findViewById<TextView>(R.id.tvAnswer)

        // Set the click listener on the flip card
        flipCard.setOnClickListener {
            // Toggle visibility between question and answer
            if (tvAnswer.visibility == TextView.GONE) {
                tvAnswer.visibility = TextView.VISIBLE
                tvQuestion.visibility = TextView.GONE
            } else {
                tvAnswer.visibility = TextView.GONE
                tvQuestion.visibility = TextView.VISIBLE
            }
        }

        // Set the deck title from the Intent
        val deckTitle = intent.getStringExtra("deckTitle")
        val deckTitleTextView = findViewById<TextView>(R.id.tvDeckTitle)
        deckTitleTextView.text = deckTitle
    }
}
