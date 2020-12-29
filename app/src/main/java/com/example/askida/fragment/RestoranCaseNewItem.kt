package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Objects.Restoran
import com.example.askida.R
import kotlinx.android.synthetic.main.fragment_restoran_case_new_item.*

class RestoranCaseNewItem: Fragment(R.layout.fragment_restoran_case_new_item)  {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_item_rest_add.setOnClickListener {
            //Restorana o item eklenicek.

        }
    }
}