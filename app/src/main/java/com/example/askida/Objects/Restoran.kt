package com.example.askida.Objects

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restoran(val id: String, val name: String, val City: String,var items : ArrayList<Item> = arrayListOf()) : Parcelable