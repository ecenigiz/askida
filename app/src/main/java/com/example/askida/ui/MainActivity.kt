package com.example.askida.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.askida.Helpers.Constants.AuthenticationFailed
import com.example.askida.Helpers.Constants.EmailVerify
import com.example.askida.Helpers.Constants.RequireMail
import com.example.askida.Helpers.Constants.RequirePassword
import com.example.askida.Helpers.Validation
import com.example.askida.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        //null patterni olabilir.
        if (user != null) {
            startUserDashboardActivity()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setInitialListeners()
    }

    fun setInitialListeners() {
        //single şeyi yap
        val validate: Validation= Validation()
        //validation state pattern valan yapabilirsin

        btn_login.setOnClickListener {
            /* var flag = false;
            if (!email.text.trim().toString().isNotEmpty()) {
                email.setError("Mail is requried ! ")
                email.requestFocus()
                flag = true
            }
            if (!password.text.trim().toString().isNotEmpty()) {
                password.setError("Password is requried ! ")
                password.requestFocus()
                flag = true
            }*/
           var flag= validate.validateSetErrorTextIsEmpty(email,RequireMail)
            flag = validate.validateSetErrorTextIsEmpty(password, RequirePassword) || flag

            if(!flag){
                prograssBar.visibility = View.VISIBLE
                auth.signInWithEmailAndPassword(
                    email.text.trim().toString(),
                    password.text.trim().toString()
                )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful()) {
                            val user: FirebaseUser = auth.getCurrentUser()!!
                            if (user.isEmailVerified) {
                                startUserDashboardActivity()
                            } else {
                                user.sendEmailVerification()
                                Toast.makeText(
                                    this,
                                    EmailVerify,
                                    Toast.LENGTH_LONG
                                )
                            }
                        }
                        else {
                            Toast.makeText(
                                this, AuthenticationFailed,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                prograssBar.visibility = View.GONE
            }
        }

        forgetPassword.setOnClickListener {
            var intent = Intent(this, ForgorPasswordActivity::class.java)
            startActivity(intent);
        }

        register.setOnClickListener {
            var intent = Intent(this, Register::class.java)
            startActivity(intent);
        }
    }

    fun startUserDashboardActivity() {
        var intent = Intent(this, DashboardUserActivity::class.java)
        prograssBar.visibility = View.GONE
        startActivity(intent);
    }
}