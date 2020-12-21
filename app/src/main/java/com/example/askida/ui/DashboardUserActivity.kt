package com.example.askida.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.askida.Objects.User
import com.example.askida.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

import kotlinx.android.synthetic.main.activity_dashboard_user.*

class DashboardUserActivity : AppCompatActivity() {
    private lateinit var user: FirebaseUser
    private lateinit var reference: DatabaseReference
    private lateinit var currentUser: User

    lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_user)

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
