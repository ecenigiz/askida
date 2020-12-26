package com.example.askida.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.askida.Helpers.Constants
import com.example.askida.Helpers.Constants.FailRegister
import com.example.askida.Helpers.Constants.SthWrong
import com.example.askida.Helpers.Constants.SuccessfullyReqister
import com.example.askida.Objects.User
import com.example.askida.R
import com.example.askida.ViewModel.MainVM
import com.example.askida.ViewModel.RegisterVM
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: User
    private lateinit var vm: RegisterVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()

        vm = ViewModelProvider(this).get(RegisterVM::class.java)

        btn_register.setOnClickListener {
            user.Name=etname.text.toString()
            user.Email=etemail.text.toString()
            user.Password=etpassword.text.toString()
            user.IsUserMarketPlace=brand_check.isChecked

            vm.registerValidation(
                etname.text.toString(),
                etemail.text.toString(),
                etpassword.text.toString()
            )
        }

        vm.registerValidationLiveData.observe(this) {
            if (it) {
                createUser(etemail.text.toString(),etpassword.text.toString())
            }
            else{
                Toast.makeText(this, "Tüm bilgileri doldurunuz",Toast.LENGTH_LONG).show()
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
                            if (it.isSuccessful) {
                                FirebaseAuth.getInstance().currentUser!!.sendEmailVerification()
                                Toast.makeText(
                                    this,
                                    Constants.EmailVerify,
                                    Toast.LENGTH_LONG
                                )
                                Toast.makeText(this, SuccessfullyReqister, Toast.LENGTH_LONG).show()
                                startUserDashboardActivity()
                            } else {
                                Toast.makeText(this, FailRegister, Toast.LENGTH_LONG).show()
                            }
                        }.addOnFailureListener {
                            Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
                        }

                } else {
                    Toast.makeText(this, SthWrong, Toast.LENGTH_LONG).show()
                }
            }.addOnFailureListener {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
            }
        prograssBar.visibility = View.GONE

    }

    fun startUserDashboardActivity() {
        var intent = Intent(this, DashboardUserActivity::class.java)
        startActivity(intent);
    }
}