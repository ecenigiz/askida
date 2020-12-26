package com.example.askida.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.example.askida.Cart
import com.example.askida.Objects.Item
import com.example.askida.Objects.User
import com.example.askida.R
import com.example.askida.fragment.CartFragment
import com.example.askida.fragment.SearchRestaurantFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

import kotlinx.android.synthetic.main.activity_dashboard_user.*

class DashboardUserActivity : AppCompatActivity() {
    private lateinit var user: FirebaseUser
    private lateinit var reference: DatabaseReference
    private lateinit var currentUser: User
    private lateinit var fragmentContainer: FragmentContainerView
    private lateinit var bottomNavigation : BottomNavigationView
    lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_user)

        fragmentContainer = findViewById(R.id.fragment_container)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        val item= Item("1","Elma",2.0,1)
        Cart.getInstance().cartMap.add(item)
        Cart.getInstance().cartMap.add(item)

        bottomNavigation.selectedItemId=R.id.item_cart
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.item_search ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,SearchRestaurantFragment()).commit()
                    true
                }
                R.id.item_cart -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,CartFragment()).commit()
                    true
                }
                R.id.item_profile -> {
                    true
                }
                else -> {false}
            }
        }

        user = FirebaseAuth.getInstance().currentUser!!
        reference = FirebaseDatabase
            .getInstance().getReference("Users")
        userId = user.uid

        reference.child(userId).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                var userProfile = snapshot.getValue(User::class.java)
                if (userProfile != null) {
                }
            }
        })
       // btn_logout.setOnClickListener {  logOut()}
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
