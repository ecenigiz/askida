package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Objects.Cart
import com.example.askida.Adapter.CartRecyclerAdapter
import com.example.askida.R
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment(R.layout.fragment_cart) {

    lateinit var cart_rv : RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(Cart.getInstance().cartMap.size>0)
             tv_emty_cart.visibility=View.GONE
        else
            tv_emty_cart.visibility=View.VISIBLE

        cart_rv = view.findViewById(R.id.cart_rv)

        cart_rv.adapter = CartRecyclerAdapter(Cart.getInstance().cartMap)

        btn_buy.setOnClickListener {
            Toast.makeText(context,"Successfully you donated !", Toast.LENGTH_LONG).show()
            Cart.getInstance().emptyCart()
            cart_rv.adapter = CartRecyclerAdapter(Cart.getInstance().cartMap)
            tv_emty_cart.visibility=View.VISIBLE
        }
        btn_take.setOnClickListener {
            Toast.makeText(context,"Successfully you take !", Toast.LENGTH_LONG).show()
            Cart.getInstance().emptyCart()
            cart_rv.adapter = CartRecyclerAdapter(Cart.getInstance().cartMap)
            tv_emty_cart.visibility=View.VISIBLE
        }


    }
}