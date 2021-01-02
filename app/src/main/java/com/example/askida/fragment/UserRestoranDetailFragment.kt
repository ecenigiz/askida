package com.example.askida.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Adapter.UserRestoranDetailAdapter
import com.example.askida.Db.RestoranDB
import com.example.askida.Helpers.Constants.ItemAdded
import com.example.askida.Objects.Cart
import com.example.askida.Objects.Restoran
import com.example.askida.Objects.Sale
import com.example.askida.R
import com.example.askida.ViewModel.UserRestoranDetailFragmentVM
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class UserRestoranDetailFragment : Fragment(R.layout.fragment_user_restaurant_detail) {

    lateinit var restoran: Restoran
    lateinit var restauran_item_rv: RecyclerView
    var vm = UserRestoranDetailFragmentVM()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        restauran_item_rv = view.findViewById(R.id.cart_rv)

        val userId=FirebaseAuth.getInstance().currentUser!!.uid

        val bundle = arguments
        if (bundle != null) restoran = bundle.getParcelable("restoran")!!

        val rest =vm.getRestorant(restoran)
        restauran_item_rv.adapter = UserRestoranDetailAdapter(rest.items) { item ->
            Toast.makeText(context, ItemAdded, Toast.LENGTH_LONG).show()
            vm.addCart(Sale("1",userId,restoran.id,item, Calendar.getInstance().time,false,1))

        }
    }
}