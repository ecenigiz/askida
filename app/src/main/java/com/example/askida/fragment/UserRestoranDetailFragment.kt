package com.example.askida.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.CartRecyclerAdapter
import com.example.askida.Objects.Cart
import com.example.askida.Objects.Restoran
import com.example.askida.R
import com.example.askida.RestoranRecyclerAdapter
import com.example.askida.UserRestoranDetailAdapter
import kotlinx.android.synthetic.main.fragment_search_restaurant.*
import java.util.logging.LogManager
import java.util.logging.Logger

class UserRestoranDetailFragment : Fragment(R.layout.fragment_user_restaurant_detail) {

    lateinit var restoran: Restoran
    lateinit var restauran_item_rv: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        restauran_item_rv = view.findViewById(R.id.cart_rv)

        val bundle = arguments
        if (bundle != null) restoran = bundle.getParcelable("restoran")!!
        restauran_item_rv.adapter = UserRestoranDetailAdapter(restoran.items) { item ->
            Cart.getInstance().cartMap.add(item)
        }

    }
}