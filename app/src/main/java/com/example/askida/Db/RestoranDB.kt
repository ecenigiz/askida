package com.example.askida.Db

import com.example.askida.Objects.Restoran
import com.example.askida.Objects.Sale
import java.util.ArrayList

class RestoranDB {
    var restoranMap: ArrayList<Restoran> = arrayListOf()

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