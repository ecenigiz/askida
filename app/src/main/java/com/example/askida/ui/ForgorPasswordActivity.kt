package com.example.askida.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.askida.Helpers.Constants
import com.example.askida.Helpers.Constants.EmailVerify
import com.example.askida.Helpers.Constants.SthWrong
import com.example.askida.Helpers.Validation
import com.example.askida.R
import com.example.askida.ViewModel.ForgotPasswordVM
import com.example.askida.ViewModel.MainVM
import com.example.askida.ViewModel.RegisterVM
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgor_password.*
import kotlinx.android.synthetic.main.activity_forgor_password.email
import kotlinx.android.synthetic.main.activity_forgor_password.prograssBar
import kotlinx.android.synthetic.main.activity_register.*

class ForgorPasswordActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    private lateinit var vm: ForgotPasswordVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgor_password)
        vm = ViewModelProvider(this).get(ForgotPasswordVM::class.java)

        auth = FirebaseAuth.getInstance()

        reset_password.setOnClickListener {
            vm.validateSetErrorTextIsEmpty(
                etemail.text.toString()
            )

        }
        vm.validationLiveData.observe(this) {
            if (it) {
                resetPassword()
            } else {
                Toast.makeText(this, "Tüm bilgileri doldurunuz", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun resetPassword() {

        val emailValue = email.text.trim().toString()
        prograssBar.visibility = View.VISIBLE
        auth.sendPasswordResetEmail(emailValue).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, EmailVerify, Toast.LENGTH_LONG).show()
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent);
            } else {
                Toast.makeText(this, SthWrong, Toast.LENGTH_LONG).show()
            }
            prograssBar.visibility = View.GONE
        }
    }
}