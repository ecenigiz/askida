package com.example.askida.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.askida.Db.RestoranDB
import com.example.askida.Objects.Item
import com.example.askida.Objects.Restoran
import com.example.askida.Objects.User

class RegisterVM : BaseViewModel() {
    private val _registerValidationLiveData = MutableLiveData<Boolean>()
    val registerValidationLiveData: LiveData<Boolean> = _registerValidationLiveData

    fun registerValidation(name: String, mail: String, password: String) {
        _registerValidationLiveData.value =
            name.isNotEmpty() && mail.isNotEmpty() && password.isNotEmpty()
    }

    fun addIfRestorant(user: User) {
        if (user.IsUserMarketPlace) {
            RestoranDB.getInstance()!!.restoranMap.add(
                Restoran(
                    user.Id,
                    user.Name,
                    user.City,
                    arrayListOf<Item>()
                )
            )
        }
    }
}