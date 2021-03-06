package com.example.askida.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.example.askida.R
import com.example.askida.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_dashboard_user.*

class DashboardRestoranActivity : AppCompatActivity() {
    private lateinit var user: FirebaseUser
    private lateinit var reference: DatabaseReference
    private lateinit var fragmentContainer: FragmentContainerView
    private lateinit var bottomNavigation: BottomNavigationView
    lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_restoran)

        fragmentContainer = findViewById(R.id.fragment_container)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_add_item -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        RestoranCaseNewItem()
                    ).commit()
                    true
                }
                R.id.item_items -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        RestoranCaseItems()
                    ).commit()
                    true
                }
                R.id.item_rest_profile -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        RestoranProfile()
                    ).commit()
                    true
                }
                else -> {
                    false
                }
            }
        }
        bottomNavigation.selectedItemId= R.id.item_items
        btn_logout.setOnClickListener { logOut() }
    }

    fun logOut() {
        FirebaseAuth.getInstance().signOut()
        startMainActivity()
    }

    fun startMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent);
    }
}