package com.example.askida.ViewModel

import com.example.askida.Db.SalesDb
import com.example.askida.Helpers.Constants
import com.example.askida.Objects.Cart

class CartFragmentVM : BaseViewModel() {

    fun isCartNotEmpty(): Boolean {
        return Cart.getInstance().cartMap.isNotEmpty()
    }

    fun donateCart(): String {
        if (!isCartNotEmpty()) {
            return "Cart is emtyp"
        }
        Cart.getInstance().cartMap.forEach {
            it.isDonated = true
            SalesDb.getInstance()?.salesMap?.add(it)
            Cart.getInstance().emptyCart()
        }
        return Constants.SuccessfullyDonate

    }

    fun takeCart(): String {
        if (!isCartNotEmpty()) {
            return "Cart is emtyp"
        }

        Cart.getInstance().cartMap.forEach {
            it.isDonated = false
            SalesDb.getInstance()?.salesMap?.add(it)
            Cart.getInstance().emptyCart()
        }

        return Constants.SuccessfullyTake
    }

}