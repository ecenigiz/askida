package com.example.askida.ViewModel

import com.example.askida.Db.RestoranDB
import com.example.askida.Objects.Restoran
import kotlinx.android.synthetic.main.fragment_search_restaurant.*

class SearchRestaurantFragmentVM:BaseViewModel() {

    fun getRestoran(city:String):List<Restoran> {
        var selectedItem =
            RestoranDB.getInstance()!!.restoranMap.filter { s -> s.City.startsWith(city) }
        return selectedItem
    }


}