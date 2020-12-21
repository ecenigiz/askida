package com.example.askida.Helpers

import android.widget.EditText

class Validation {
    fun validateSetErrorTextIsEmpty(text: EditText, errorMessage: String): Boolean {
        val isEmpty = (!text.text.trim().toString().isNotEmpty())
        if (isEmpty) text.setError(errorMessage)
        return isEmpty
    }
}