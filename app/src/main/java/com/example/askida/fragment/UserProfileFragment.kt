package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.askida.Db.SalesDb
import com.example.askida.R
import com.example.askida.ViewModel.UserProfileFragmentVM
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_user_profile.*

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    val vm = UserProfileFragmentVM()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*var userId= FirebaseAuth.getInstance().currentUser!!.uid
        var totalDonated=0
        var totalItem=0
        SalesDb.getInstance()!!.salesMap.forEach{
            if (it.userId==userId ) {
                if (it.isDonated) {
                    totalDonated++
                }
                else
                    totalItem++
            }
        }*/
        vm.calculateCount()
        tv_help_count.text = vm.totalDonated.toString()
        tv_help_count_total.text = vm.totalTaken.toString()
    }
}