package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {

    private var _quantity = MutableLiveData(0)
    private var _flavor = MutableLiveData("")
    private var _date = MutableLiveData("")
    private var _price = MutableLiveData(0.0)

    val quantity: LiveData<Int> get() = _quantity
    val flavor: LiveData<String> get() = _flavor
    val date: LiveData<String> get() = _date
    val price: LiveData<Double> get() = _price

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setDate(pickUpDate: String) {
        _date.value = pickUpDate
    }
}