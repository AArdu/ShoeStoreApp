package com.outlook.alessandroardu.shoestore.screens.shoe_list

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// INOTE Use a LiveData field that returns the list of shoes
@Parcelize
data class Shoe(
    var name: String, var size: String, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable