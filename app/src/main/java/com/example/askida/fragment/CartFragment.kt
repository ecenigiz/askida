package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Objects.Cart
import com.example.askida.Adapter.CartRecyclerAdapter
import com.example.askida.Db.SalesDb
import com.example.askida.Helpers.Constants.SuccessfullyDonate
import com.example.askida.Helpers.Constants.SuccessfullyTake
import com.example.askida.Helpers.Constants.sdf
import com.example.askida.Objects.Item
import com.example.askida.Objects.Restoran
import com.example.askida.Objects.Sale
import com.example.askida.R
import com.example.askida.ViewModel.CartFragmentVM
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_cart.*
import java.time.LocalDateTime
import java.util.*

class CartFragment : Fragment(R.layout.fragment_cart) {

    lateinit var cart_rv: RecyclerView
    val vm = CartFragmentVM()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (vm.isCartNotEmpty())
            tv_emty_cart.visibility = View.GONE
        else
            tv_emty_cart.visibility = View.VISIBLE

        cart_rv = view.findViewById(R.id.cart_rv)
        cart_rv.adapter = CartRecyclerAdapter(Cart.getInstance().cartMap)

        btn_buy.setOnClickListener {
            var message = vm.donateCart()
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            cart_rv.adapter = CartRecyclerAdapter(Cart.getInstance().cartMap)
            tv_emty_cart.visibility = View.VISIBLE
        }
        btn_take.setOnClickListener {
            var message = vm.takeCart()
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            cart_rv.adapter = CartRecyclerAdapter(Cart.getInstance().cartMap)
            tv_emty_cart.visibility = View.VISIBLE
        }
    }
}