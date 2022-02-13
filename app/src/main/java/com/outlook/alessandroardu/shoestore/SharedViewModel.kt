package com.outlook.alessandroardu.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.outlook.alessandroardu.shoestore.screens.shoe_list.Shoe

class SharedViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = ArrayList()
    }

    fun appendShoes(newShoe: Shoe) {
        _shoeList.value?.add(newShoe)
        _shoeList.value = _shoeList.value
    }

    fun getShoeList(): List<Shoe>? {
        return shoeList.value?.toList()
    }

}