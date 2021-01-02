package com.example.askida.ViewModel

import com.example.askida.Db.SalesDb
import com.example.askida.Objects.Cart

class CartFragmentVM:BaseViewModel() {

    fun isCartNotEmpty():Boolean{
        return Cart.getInstance().cartMap.size>0
    }

    fun donateCart(){
        Cart.getInstance().cartMap.forEach{
            it.isDonated=true
            SalesDb.getInstance()?.salesMap?.add(it)
        }
    }

    fun takCart(){
        Cart.getInstance().cartMap.forEach{
            it.isDonated=false
            SalesDb.getInstance()?.salesMap?.add(it)
        }
    }
}