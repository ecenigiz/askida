package com.example.askida.ViewModel

import com.example.askida.Db.SalesDb
import com.google.firebase.auth.FirebaseAuth

class UserProfileFragmentVM : BaseViewModel() {
    var totalDonated = 0

    var totalTaken = 0

    fun calculateCount() {
        var userId = FirebaseAuth.getInstance().currentUser!!.uid

        SalesDb.getInstance()!!.salesMap.forEach {
            if (it.userId.equals( userId)) {
                if (it.isDonated) {
                    totalDonated+=it.quantity
                } else
                    totalTaken+=it.quantity
            }
        }
    }
}