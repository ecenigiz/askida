package com.example.askida.Objects

import java.util.*

class Cart {

    var cartMap : ArrayList<Item> = arrayListOf()

    fun emptyCart() {
        cartMap.clear()
    }

    companion object {
        private var cart: Cart? = null

        fun getInstance(): Cart {
            if (cart == null) {
                cart = Cart()
            }
            return cart!!
        }
    }
}