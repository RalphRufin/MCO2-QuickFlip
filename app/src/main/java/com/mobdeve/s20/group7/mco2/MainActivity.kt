package com.mobdeve.s20.group7.mco2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBaseComponents()


        val deckButton: ImageButton = findViewById(R.id.deckButton)
        val browseButton: ImageButton = findViewById(R.id.browseButton)
        val storeButton: ImageButton = findViewById(R.id.storeButton)
        val testButton: ImageButton = findViewById(R.id.testButton)

        deckButton.setOnClickListener {
            val intent = Intent(this, DeckActivity::class.java)
            startActivity(intent)
        }

        browseButton.setOnClickListener {
            onBrowseButtonClick()
        }

        storeButton.setOnClickListener {
            onStoreButtonClick()
        }

        testButton.setOnClickListener {
            onTestButtonClick()
        }
    }

    private fun onDeckButtonClick() {
        // TODO: Implement Deck activity launch
    }

    private fun onBrowseButtonClick() {
        // TODO: Implement Browse activity launch
    }

    private fun onStoreButtonClick() {
        // TODO: Implement Store activity launch
    }

    private fun onTestButtonClick() {
        // TODO: Implement Test activity launch
    }
}