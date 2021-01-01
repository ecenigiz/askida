package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Objects.Item
import com.example.askida.Objects.Restoran
import com.example.askida.R
import com.example.askida.Adapter.RestoranRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_search_restaurant.*

class SearchRestaurantFragment : Fragment(R.layout.fragment_search_restaurant) {

    lateinit var restaurant_rv: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        restaurant_rv = view.findViewById(R.id.restaurant_rv)


        btn_search.setOnClickListener { getRestoran() }
    }

    fun getRestoran() {
        var items: ArrayList<Restoran> = ArrayList<Restoran>()

        var restoran = Restoran("1", "mağaza1", "İstanbul")
        val item= Item("1","Elma",2.0,1)

        restoran.items.add(item)
        restoran.items.add(item)
        items.add(restoran)
         restoran = Restoran("2", "magaza2", "İstanbul")
        restoran.items.add(item)
        restoran.items.add(item)
        items.add(restoran)

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
        var selectedItem=items.filter { s-> s.City.startsWith(et_city.text) }
        restaurant_rv.adapter = RestoranRecyclerAdapter(selectedItem){
            item->

            var bundle = Bundle()
            bundle.putParcelable("restoran", item)
            var frag = UserRestoranDetailFragment()
            frag.arguments = bundle

            parentFragmentManager.beginTransaction().replace(R.id.fragment_container,frag)
                .commit()
        }
    }
}