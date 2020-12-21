package com.example.askida.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.askida.Helpers.Constants
import com.example.askida.Helpers.Constants.FailRegister
import com.example.askida.Helpers.Constants.SthWrong
import com.example.askida.Helpers.Constants.SuccessfullyReqister
import com.example.askida.Helpers.Validation
import com.example.askida.Objects.User
import com.example.askida.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: User
    private var flag = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()

        btn_register.setOnClickListener {
            val validate: Validation = Validation()
            var flag= validate.validateSetErrorTextIsEmpty(etname, Constants.RequireName)
            flag = validate.validateSetErrorTextIsEmpty(etemail, Constants.RequireMail) || flag
            flag = validate.validateSetErrorTextIsEmpty(etpassword, Constants.RequirePassword) ||flag

            if (!flag) {
                prograssBar.visibility = View.VISIBLE
                createUser(user.Email, user.Password)
            }
        }
    }

    fun createUser(email: String, password: String) {
        //Patternin adını yaz functional olması +listener
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //user database ine yazcaz şimdi
                    FirebaseDatabase.getInstance().getReference("Users")
                        .child(FirebaseAuth.getInstance().uid!!)
                        .setValue(user).addOnCompleteListener {
                            if(it.isSuccessful){
                                FirebaseAuth.getInstance().currentUser!!.sendEmailVerification()
                                Toast.makeText(
                                    this,
                                    Constants.EmailVerify,
                                    Toast.LENGTH_LONG
                                )
                                Toast.makeText(this,SuccessfullyReqister, Toast.LENGTH_LONG).show()
                                startUserDashboardActivity()
                            }
                            else{
                                Toast.makeText(this,FailRegister, Toast.LENGTH_LONG).show()
                            }
                        }

                } else {
                    Toast.makeText(this, SthWrong, Toast.LENGTH_LONG).show()
                }
            }
        prograssBar.visibility = View.GONE

    }

    fun startUserDashboardActivity() {
        var intent = Intent(this, DashboardUserActivity::class.java)
        startActivity(intent);
    }
}