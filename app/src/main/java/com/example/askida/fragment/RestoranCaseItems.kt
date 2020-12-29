package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Objects.Cart
import com.example.askida.Objects.Item
import com.example.askida.Objects.Restoran
import com.example.askida.R
import com.example.askida.RestoranItemsAdaptor
import com.example.askida.UserRestoranDetailAdapter

class RestoranCaseItems: Fragment(R.layout.fragment_restoran_case_items) {
    lateinit var restoran: Restoran
    lateinit var restauran_item_rv: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        restauran_item_rv = view.findViewById(R.id.restoran_list_items_rv)
        restoran= Restoran("1","Magaza 1",  "İstanbul")
        restoran.items.add(Item("1","Elma", 3.0,3))
        val bundle = arguments
        restoran= Restoran("1","Mağaza1","İstanbul")
        restoran.items.add(Item("1","Elma",2.0,1))

        if (bundle != null) restoran = bundle.getParcelable("restoran")!!
        restauran_item_rv.adapter = RestoranItemsAdaptor(restoran.items) { item ->
            //item silincek
        }

    }
}