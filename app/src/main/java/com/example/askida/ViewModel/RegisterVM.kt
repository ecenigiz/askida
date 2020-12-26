package com.example.askida.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterVM :BaseViewModel(){
    private val _registerValidationLiveData = MutableLiveData<Boolean>()
    val registerValidationLiveData :LiveData<Boolean> = _registerValidationLiveData

    fun registerValidation(name:String,mail:String, password:String){
        _registerValidationLiveData.value = name.isNotEmpty() && mail.isNotEmpty() && password.isNotEmpty()
    }
}