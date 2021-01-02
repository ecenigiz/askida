package com.example.askida.ViewModel

import com.example.askida.Db.RestoranDB
import com.example.askida.Objects.Cart
import com.example.askida.Objects.Restoran
import com.example.askida.Objects.Sale
import com.google.firebase.auth.FirebaseAuth

class UserRestoranDetailFragmentVM:BaseViewModel() {

    fun getRestorant(restoran:Restoran):Restoran{
      return  RestoranDB.getInstance()!!.restoranMap.find { it.id.equals(restoran.id) }!!

    }

    fun addCart(sale: Sale) {
        Cart.getInstance().cartMap.add(sale )
    }
}