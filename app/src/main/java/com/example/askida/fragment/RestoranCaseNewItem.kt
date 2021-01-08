package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.askida.Db.RestoranDB
import com.example.askida.Helpers.Constants.SuccessfullyAdded
import com.example.askida.Objects.Item
import com.example.askida.Objects.Restoran
import com.example.askida.R
import com.example.askida.ViewModel.RestoranCaseNewItemVM
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_restoran_case_new_item.*

class RestoranCaseNewItem : Fragment(R.layout.fragment_restoran_case_new_item) {

    val vm= RestoranCaseNewItemVM()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            btn_item_rest_add.setOnClickListener {
                Toast.makeText(context,SuccessfullyAdded, Toast.LENGTH_LONG).show()
                vm.addItem( Item(
                    "1",
                    et_item_name.text.toString(),
                    et_item_price.text.toString().toDouble()
                ))
                et_item_name.setText("")
                et_item_price.setText("")
            }
    }
}