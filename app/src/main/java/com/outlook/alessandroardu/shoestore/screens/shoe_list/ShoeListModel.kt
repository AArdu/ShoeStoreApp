package com.outlook.alessandroardu.shoestore.screens.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.outlook.alessandroardu.shoestore.MainActivityModel
import timber.log.Timber

//INOTE Create a class that extends ViewModel
class ShoeListModel(newShoe: Shoe, shouldSaveNewShoe: Boolean) : ViewModel() {
    // INOTE Use a LiveData field that returns the list of shoes
    private var mshoeList = ArrayList<Shoe>()
    private var _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private var _shouldSave = MutableLiveData<Boolean>()
    val shouldSave: LiveData<Boolean>
        get() = _shouldSave

    private var _hasAddedViews = MutableLiveData<Boolean>()
    val hasAddedViews: LiveData<Boolean>
        get() = _hasAddedViews

    private val mainActivityModel: MainActivityModel = MainActivityModel()

    init {
        _shouldSave.value = shouldSaveNewShoe
        if (_shouldSave.value == true) {
            Timber.i("adding new shoe to list")
            mainActivityModel.appendShoes(newShoe)
            _shouldSave.value = false
            Timber.i("SHOE %s", newShoe)
            Timber.i("shoeList %s", _shoeList.value.toString())

        }

    }

    fun addShoeStart() {
        _hasAddedViews.value = false
    }

    fun addShoeComplete() {
        _hasAddedViews.value = true
    }

    fun getShoeList(): List<Shoe>? {
        return shoeList.value
    }



}