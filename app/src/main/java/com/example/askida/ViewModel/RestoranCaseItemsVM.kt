package com.example.askida.ViewModel

import com.example.askida.Db.RestoranDB
import com.example.askida.Objects.Restoran
import com.google.firebase.auth.FirebaseAuth

class RestoranCaseItemsVM:BaseViewModel() {

    fun getRestorant():Restoran{
        var rest =RestoranDB.getInstance()!!.restoranMap.find {
            it.id.equals(FirebaseAuth.getInstance().uid)
        }!!
        return  rest
    }
}