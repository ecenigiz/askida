package com.example.askida.Objects

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(val id:String, val name: String, val price:Double, var quantity:Int) : Parcelable