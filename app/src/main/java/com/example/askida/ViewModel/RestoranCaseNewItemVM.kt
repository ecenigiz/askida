package com.example.askida.ViewModel

import com.example.askida.Db.RestoranDB
import com.example.askida.Objects.Item
import com.example.askida.Objects.Restoran
import com.google.firebase.auth.FirebaseAuth

class RestoranCaseNewItemVM : BaseViewModel() {


    fun addItem(item: Item){
        var rest =
            RestoranDB.getInstance()!!.restoranMap.find { it.id.equals(FirebaseAuth.getInstance().uid) }!!

        rest.items.add(item)
    }
}