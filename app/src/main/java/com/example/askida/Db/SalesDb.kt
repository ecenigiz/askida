package com.example.askida.Db

import com.example.askida.Objects.Sale
import java.util.ArrayList

class SalesDb {
    var salesMap: ArrayList<Sale> = arrayListOf()

    companion object {
        private var sales: SalesDb? = null

        fun getInstance(): SalesDb? {
            if (sales == null) {
                sales = SalesDb()
            }

            return sales!!
        }
    }
}