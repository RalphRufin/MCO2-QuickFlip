package com.mobdeve.s20.group7.mco2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
class DeckActivity : BaseActivity() {

    private lateinit var fabMain: FloatingActionButton
    private lateinit var fabFindDeck: FloatingActionButton
    private lateinit var fabImportDeck: FloatingActionButton
    private lateinit var fabShareDeck: FloatingActionButton
    private lateinit var tvFindDeck: TextView
    private lateinit var tvImportDeck: TextView
    private lateinit var tvShareDeck: TextView
    private lateinit var rvDecks: RecyclerView

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim) }

    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deck)
        setupBaseComponents()

        fabMain = findViewById(R.id.fabMain)
        fabFindDeck = findViewById(R.id.fabFindDeck)
        fabImportDeck = findViewById(R.id.fabImportDeck)
        fabShareDeck = findViewById(R.id.fabShareDeck)
        tvFindDeck = findViewById(R.id.tvFindDeck)
        tvImportDeck = findViewById(R.id.tvImportDeck)
        tvShareDeck = findViewById(R.id.tvShareDeck)
        rvDecks = findViewById(R.id.rvDecks)

        fabMain.setOnClickListener {
            onAddButtonClicked()
        }

        fabFindDeck.setOnClickListener {
            // TODO: Implement find deck functionality
        }

        fabImportDeck.setOnClickListener {
            // TODO: Implement import deck functionality
        }

        fabShareDeck.setOnClickListener {
            // TODO: Implement share deck functionality
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val deckItems = createSampleDeckItems() // Replace with actual data source
        val adapter = DeckAdapter(deckItems) { deckItem ->
            // On deck click, open SpeedTActivity with the selected deck
            val intent = Intent(this, SpeedTActivity::class.java)
            intent.putExtra("deckTitle", deckItem.getDeckTitle())
            intent.putExtra("deckCards", ArrayList(deckItem.cardItems))  // Passing cards to the next activity
            startActivity(intent)
        }
        rvDecks.layoutManager = GridLayoutManager(this, 3)
        rvDecks.adapter = adapter
    }

    private fun createSampleDeckItems(): List<DeckItem> {
        // This is just for demonstration. Replace with your actual data source.
        return listOf(
            DeckItem("@drawable/quickflipdeckicon", "Deck 1"),
            DeckItem("@drawable/quickflipdeckicon", "Deck 2"),
            DeckItem("@drawable/quickflipdeckicon", "Deck 3")
        )
    }

    private fun onAddButtonClicked() {
        setVisibility(isExpanded)
        setAnimation(isExpanded)
        isExpanded = !isExpanded
    }

    private fun setVisibility(isExpanded: Boolean) {
        if (!isExpanded) {
            fabFindDeck.visibility = View.VISIBLE
            fabImportDeck.visibility = View.VISIBLE
            fabShareDeck.visibility = View.VISIBLE
            tvFindDeck.visibility = View.VISIBLE
            tvImportDeck.visibility = View.VISIBLE
            tvShareDeck.visibility = View.VISIBLE
        } else {
            fabFindDeck.visibility = View.GONE
            fabImportDeck.visibility = View.GONE
            fabShareDeck.visibility = View.GONE
            tvFindDeck.visibility = View.GONE
            tvImportDeck.visibility = View.GONE
            tvShareDeck.visibility = View.GONE
        }
    }

    private fun setAnimation(isExpanded: Boolean) {
        if (!isExpanded) {
            fabMain.startAnimation(rotateOpen)
            fabFindDeck.startAnimation(fromBottom)
            fabImportDeck.startAnimation(fromBottom)
            fabShareDeck.startAnimation(fromBottom)
            tvFindDeck.startAnimation(fromBottom)
            tvImportDeck.startAnimation(fromBottom)
            tvShareDeck.startAnimation(fromBottom)
        } else {
            fabMain.startAnimation(rotateClose)
            fabFindDeck.startAnimation(toBottom)
            fabImportDeck.startAnimation(toBottom)
            fabShareDeck.startAnimation(toBottom)
            tvFindDeck.startAnimation(toBottom)
            tvImportDeck.startAnimation(toBottom)
            tvShareDeck.startAnimation(toBottom)
        }
    }
}
