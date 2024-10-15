package com.mobdeve.s20.group7.mco2

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StoreActivity : BaseActivity() {

    private lateinit var rvStoreItems: RecyclerView
    private lateinit var storeAdapter: StoreAdapter
    private val storeItems = mutableListOf<StoreItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        // Initialize the RecyclerView
        rvStoreItems = findViewById(R.id.rvStoreItems)

        // Set layout manager (GridLayoutManager for grid-like appearance)
        rvStoreItems.layoutManager = GridLayoutManager(this, 3) // 2 columns grid

        // Initialize store items
        loadStoreItems()

        // Initialize adapter and set it to RecyclerView
        storeAdapter = StoreAdapter(this, storeItems)
        rvStoreItems.adapter = storeAdapter
    }

    // Method to populate store items (you can fetch real data from a server or database)
    private fun loadStoreItems() {
        storeItems.add(StoreItem("Dark Mode", 200, R.drawable.quickflipnightmodeicon))
        storeItems.add(StoreItem("More Stamina", 300, R.drawable.quickflipbatteryicon))
        storeItems.add(StoreItem("More Decks", 100, R.drawable.quickflipmoredecksicon))
        // Add more items as needed
    }
}
