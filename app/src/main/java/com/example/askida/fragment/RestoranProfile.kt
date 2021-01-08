package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.askida.Db.SalesDb
import com.example.askida.R
import com.example.askida.ViewModel.RestoranProfileVM
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_restoran_profile.*

class RestoranProfile : Fragment(R.layout.fragment_restoran_profile) {
    val vm = RestoranProfileVM()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.calculateCount()
        tv_help_count.text = vm.totalDonated.toString()
        tv_help_count_total.text = vm.total.toString()
        profile_name.text = vm.getRestorant()
    }
}