package com.example.askida.Db

import com.example.askida.Objects.Item
import com.example.askida.Objects.Restoran
import com.example.askida.Objects.Sale
import java.time.LocalDate
import java.util.*

class DbInitial {
    companion object {
        private var db: DbInitial? = null

        fun getInstance(): DbInitial? {
            if (db == null) {
                db = DbInitial()
                var restoran = Restoran("mgHDEteDGcWIloBW5K5oUffcfBd2", "Gıdadaki Herşey", "istanbul")
                val itemElma= Item("1","Elma",2.0)
                val itemArmut= Item("1","Armut",2.0)

                restoran.items.add(itemElma)
                restoran.items.add(itemArmut)
                RestoranDB.getInstance()!!.restoranMap.add(restoran)

                restoran = Restoran("L9DivYy678efw2yQh2pBQFGaiHu1", "YemekBuradaYenir", "istanbul")
                restoran.items.add(itemElma)
                restoran.items.add(itemArmut)
                RestoranDB.getInstance()!!.restoranMap.add(restoran)

                restoran = Restoran("cOpPkjue3sUvV9XTzv6FdkRVPYB3", "Kadıköy Bakkal", "istanbul")
                restoran.items.add(itemElma)
                restoran.items.add(itemArmut)
                RestoranDB.getInstance()!!.restoranMap.add(restoran)

                restoran = Restoran("UrKujMCIBCS38eFIUWPbmOetEgH2", "Izmir Bakkal", "istanbul")
                restoran.items.add(itemElma)
                restoran.items.add(itemArmut)
                RestoranDB.getInstance()!!.restoranMap.add(restoran)

                SalesDb.getInstance()!!.salesMap.add(Sale("1","fBwZUn8YHKgE5Xdv1icg4hRMClH2","cOpPkjue3sUvV9XTzv6FdkRVPYB3",itemArmut,
                    Calendar.getInstance().time,true,4))
                SalesDb.getInstance()!!.salesMap.add(Sale("1","fBwZUn8YHKgE5Xdv1icg4hRMClH2","cOpPkjue3sUvV9XTzv6FdkRVPYB3",itemArmut,
                    Calendar.getInstance().time,false,2))
            }

            return db!!
        }
    }
}