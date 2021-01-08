package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.R
import com.example.askida.Adapter.RestoranItemsAdapter
import com.example.askida.Helpers.Constants.SuccessfullyDeleted
import com.example.askida.ViewModel.RestoranCaseItemsVM
import kotlinx.android.synthetic.main.fragment_restoran_case_items.*

class RestoranCaseItems : Fragment(R.layout.fragment_restoran_case_items) {

    val vm = RestoranCaseItemsVM()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val restauran_item_rv = view.findViewById<RecyclerView>(R.id.restoran_list_items_rv)

        val rest = vm.getRestorant()
        item_rest_name.text = rest.name

        restauran_item_rv.adapter = RestoranItemsAdapter(rest.items) { item ->
            Toast.makeText(context, SuccessfullyDeleted, Toast.LENGTH_LONG).show()

            rest.items.remove(item)
            restauran_item_rv.adapter!!.notifyDataSetChanged()
        }
    }
}