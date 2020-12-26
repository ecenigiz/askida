package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Cart
import com.example.askida.CartRecyclerAdapter
import com.example.askida.R

class CartFragment : Fragment(R.layout.fragment_cart) {

    lateinit var cart_rv : RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cart_rv = view.findViewById(R.id.cart_rv)

        cart_rv.adapter = CartRecyclerAdapter(Cart.getInstance().cartMap)
    }
}