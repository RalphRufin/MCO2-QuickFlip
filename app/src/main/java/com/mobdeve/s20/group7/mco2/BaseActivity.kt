package com.mobdeve.s20.group7.mco2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

open class BaseActivity : AppCompatActivity() {

    protected lateinit var drawerLayout: DrawerLayout
    protected lateinit var navigationView: NavigationView
    protected lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun setupBaseComponents() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = null

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_menu)

        val logoImageView: ImageButton = findViewById(R.id.logoImageView)
        val drawerButton: ImageButton = findViewById(R.id.drawerButton)

        logoImageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

        drawerButton.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        setupNavigationView()
    }

    private fun setupNavigationView() {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_decks -> {
                    true
                }
                R.id.nav_cardbrowse -> {
                    true
                }
                R.id.nav_settings -> {
                    true
                }
                R.id.nav_help -> {
                    true
                }
                R.id.nav_support -> {
                    true
                }
                R.id.nav_leaderboard -> {
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_check -> {
                Toast.makeText(this, "Check selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_restore -> {
                Toast.makeText(this, "Restore from backup selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_import -> {
                Toast.makeText(this, "Import selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_export -> {
                Toast.makeText(this, "Export selected", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}