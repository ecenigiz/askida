package com.example.askida

import com.example.askida.Objects.Item
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