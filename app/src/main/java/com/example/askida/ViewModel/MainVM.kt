package com.example.askida.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainVM : BaseViewModel() {
    private val _registerValidationLiveData = MutableLiveData<Boolean>()
    val registerValidationLiveData: LiveData<Boolean> = _registerValidationLiveData

    fun registerValidation(mail: String, password: String) {
        _registerValidationLiveData.value =(mail.isNotEmpty() && password.isNotEmpty())
    }
}