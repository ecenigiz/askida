package com.example.askida.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.askida.Helpers.Constants.AuthenticationFailed
import com.example.askida.Helpers.Constants.EmailVerify
import com.example.askida.Helpers.Constants.RequireMail
import com.example.askida.Helpers.Constants.RequirePassword
import com.example.askida.Helpers.Validation
import com.example.askida.R
import com.example.askida.ViewModel.MainVM
import com.example.askida.ViewModel.RegisterVM
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.prograssBar
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private var vm=MainVM()

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
        vm = ViewModelProvider(this).get(MainVM::class.java)
        setInitialListeners()

    }

    fun setInitialListeners() {
        btn_login.setOnClickListener {
            vm.registerValidation(
                email.text.toString(),
                password.text.toString()
            )
        }

        vm.registerValidationLiveData.observe(this) {
            if (it) {
                prograssBar.visibility = View.VISIBLE
                auth.signInWithEmailAndPassword(
                    email.text.toString(),
                    password.text.toString()
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
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                this, AuthenticationFailed,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                prograssBar.visibility = View.GONE
            } else {
                Toast.makeText(this, "Please fill in all the information", Toast.LENGTH_LONG).show()
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
        //var intent = Intent(this, DashboardUserActivity::class.java)
        var intent = Intent(this, DashboardRestoranActivity::class.java)
        prograssBar.visibility = View.GONE
        startActivity(intent);
    }
}