package com.example.askida.ViewModel

import com.example.askida.Db.RestoranDB
import com.example.askida.Db.SalesDb
import com.example.askida.Objects.Restoran
import com.google.firebase.auth.FirebaseAuth

class RestoranProfileVM : BaseViewModel() {
    var totalDonated = 0
    var remainingCount=0
    var totalTaken = 0
    var total=0

    fun calculateCount() {
        var userId = FirebaseAuth.getInstance().currentUser!!.uid

        SalesDb.getInstance()!!.salesMap.forEach {
            if (it.restoranId.equals(userId)) {
                if (it.isDonated) {
                    totalDonated += it.quantity
                }

                totalTaken += it.quantity
            }
        }
        total=totalTaken+totalDonated
        remainingCount=totalDonated-totalTaken

    }

    fun getRestorant(): String {
        var rest = RestoranDB.getInstance()!!.restoranMap.find {
            it.id.equals(FirebaseAuth.getInstance().uid)
        }!!
        return  rest.name
    }
}