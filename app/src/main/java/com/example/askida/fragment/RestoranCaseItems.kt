package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Adapter.CartRecyclerAdapter
import com.example.askida.Objects.Item
import com.example.askida.Objects.Restoran
import com.example.askida.R
import com.example.askida.Adapter.RestoranItemsAdaptor
import com.example.askida.Db.RestoranDB
import com.example.askida.Objects.Cart
import com.example.askida.ViewModel.RestoranCaseItemsVM
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_restoran_case_items.*

class RestoranCaseItems : Fragment(R.layout.fragment_restoran_case_items) {

    val vm= RestoranCaseItemsVM()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var restauran_item_rv = view.findViewById<RecyclerView>(R.id.restoran_list_items_rv)

        var rest = vm.getRestorant()
        item_rest_name.text=rest.name

        restauran_item_rv.adapter = RestoranItemsAdaptor(rest.items) { item ->
            Toast.makeText(context,"Successfully deleted !", Toast.LENGTH_LONG).show()

            rest.items.remove(item)
            restauran_item_rv.adapter!!.notifyDataSetChanged()
        }
    }
}