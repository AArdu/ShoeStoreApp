package com.outlook.alessandroardu.shoestore.screens.shoe_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ShoeListModelFactory(private val newShoe: Shoe, private val shouldSave: Boolean): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeListModel::class.java)) {
            return ShoeListModel(newShoe, shouldSave) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}