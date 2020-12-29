package com.example.askida.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.R
import kotlinx.android.synthetic.main.fragment_user_profile.*

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_help_label_total.setText("Sistemden"+ System.getProperty("line.separator") + "aldığınız sayı")
        super.onViewCreated(view, savedInstanceState)
    }
}