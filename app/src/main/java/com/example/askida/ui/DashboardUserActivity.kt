package com.example.askida.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import com.example.askida.R
import com.example.askida.fragment.CartFragment
import com.example.askida.fragment.SearchRestaurantFragment
import com.example.askida.fragment.UserProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

import kotlinx.android.synthetic.main.activity_dashboard_user.*

class DashboardUserActivity : AppCompatActivity() {
    private lateinit var user: FirebaseUser
    private lateinit var reference: DatabaseReference
    private lateinit var fragmentContainer: FragmentContainerView
    private lateinit var bottomNavigation : BottomNavigationView
    lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_user)

        fragmentContainer = findViewById(R.id.fragment_container)
        bottomNavigation = findViewById(R.id.bottom_navigation)

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
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,UserProfileFragment()).commit()
                    true
                }
                else -> {false}
            }
        }

        /* userId=""
         user = FirebaseAuth.getInstance().currentUser!!
         reference = FirebaseDatabase
             .getInstance().getReference().child("Users").child(userId)
         userId = user.uid

         reference.child(userId).addListenerForSingleValueEvent(object : ValueEventListener {
             override fun onCancelled(error: DatabaseError) {
             }

             override fun onDataChange(snapshot: DataSnapshot) {
                 var userProfile = snapshot.getValue(User::class.java)
                 if (userProfile != null) {
                     currentUser=userProfile
                 }
             }
         })*/
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show()

        btn_logout.setOnClickListener {  logOut()}
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
