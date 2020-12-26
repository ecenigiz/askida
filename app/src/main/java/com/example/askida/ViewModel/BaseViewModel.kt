package com.example.askida.ViewModel

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    private val _validationLiveData = MutableLiveData<Boolean>()
    val validationLiveData :LiveData<Boolean> = _validationLiveData

    fun validateSetErrorTextIsEmpty(text:String) {
        val isEmpty = (!text.trim().isNotEmpty())
        _validationLiveData.value =isEmpty
    }
}