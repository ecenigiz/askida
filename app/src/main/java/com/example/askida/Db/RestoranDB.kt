package com.example.askida.Db

import com.example.askida.Objects.Sale
import java.util.ArrayList

class RestoranDB {
    var saleMap: ArrayList<Sale> = arrayListOf()

    companion object {
        private var restoran: RestoranDB? = null

        fun getInstance(): RestoranDB? {
            if (restoran == null) {
                restoran = RestoranDB()
            }

            return restoran!!
        }
    }
}