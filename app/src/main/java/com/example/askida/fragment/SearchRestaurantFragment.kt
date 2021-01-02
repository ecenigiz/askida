package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Objects.Item
import com.example.askida.Objects.Restoran
import com.example.askida.R
import com.example.askida.Adapter.RestoranRecyclerAdapter
import com.example.askida.Db.RestoranDB
import com.example.askida.ViewModel.SearchRestaurantFragmentVM
import kotlinx.android.synthetic.main.fragment_search_restaurant.*

class SearchRestaurantFragment : Fragment(R.layout.fragment_search_restaurant) {

    lateinit var restaurant_rv: RecyclerView
    val vm = SearchRestaurantFragmentVM()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        restaurant_rv = view.findViewById(R.id.restaurant_rv)

        btn_search.setOnClickListener {
            val selectedItem = vm.getRestoran(et_city.text.toString())
            restaurant_rv.adapter = RestoranRecyclerAdapter(selectedItem) { restoran ->
                val bundle = Bundle()
                bundle.putParcelable("restoran", restoran)
                val frag = UserRestoranDetailFragment()
                frag.arguments = bundle

                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, frag)
                    .commit()
            }
        }
    }
}
/*
    fun getRestoran() {
        var selectedItem=RestoranDB.getInstance()!!.restoranMap.filter { s-> s.City.startsWith(et_city.text) }
        restaurant_rv.adapter = RestoranRecyclerAdapter(selectedItem){
            item->

            var bundle = Bundle()
            bundle.putParcelable("restoran", item)
            var frag = UserRestoranDetailFragment()
            frag.arguments = bundle

            CartFragment().arguments=bundle

            parentFragmentManager.beginTransaction().replace(R.id.fragment_container,frag)
                .commit()
        }
    }*/

/*var db = FirebaseFirestore.getInstance()

db.collection("Users").get().addOnSuccessListener { result ->
    for (document in result) {
        items.add(document.toObject<Restoran>())
        Log.d(TAG, "LOG!!${document.id} => ${document.data}")
    }
}
    .addOnFailureListener { exception ->
        Log.d(TAG, "Error getting documents: ", exception)
    }
*/