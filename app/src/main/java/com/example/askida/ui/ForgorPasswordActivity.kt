package com.example.askida.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.askida.Helpers.Constants
import com.example.askida.Helpers.Constants.EmailVerify
import com.example.askida.Helpers.Constants.SthWrong
import com.example.askida.Helpers.Validation
import com.example.askida.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgor_password.*
import kotlinx.android.synthetic.main.activity_forgor_password.email
import kotlinx.android.synthetic.main.activity_forgor_password.prograssBar

class ForgorPasswordActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgor_password)

        auth = FirebaseAuth.getInstance()

        reset_password.setOnClickListener {
            resetPassword()
        }

    }

    fun resetPassword() {
        val validate: Validation = Validation()
        var flag= validate.validateSetErrorTextIsEmpty(email, Constants.RequireMail)

       val emailValue = email.text.trim().toString()
       /* if (emailValue.isEmpty()) {
            email.setError("Email is required ! ")
            email.requestFocus()
        }
        else if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
            email.setError("Email is not valid ! ")
            email.requestFocus()
        }*/
        //email valid mi????
        if(!flag) {
            prograssBar.visibility = View.VISIBLE
            auth.sendPasswordResetEmail(emailValue).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this,EmailVerify,Toast.LENGTH_LONG).show()
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent);
                }else{
                    Toast.makeText(this,SthWrong,Toast.LENGTH_LONG).show()
                }
                prograssBar.visibility = View.GONE
            }
        }
    }
}