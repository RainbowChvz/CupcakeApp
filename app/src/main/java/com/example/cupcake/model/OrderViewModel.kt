package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderViewModel: ViewModel() {

    private var _quantity = MutableLiveData<Int>()
    private var _flavor = MutableLiveData<String>()
    private var _date = MutableLiveData<String>()
    private var _price = MutableLiveData<Double>()

    val quantity: LiveData<Int> get() = _quantity
    val flavor: LiveData<String> get() = _flavor
    val date: LiveData<String> get() = _date
    val price: LiveData<Double> get() = _price
    val dateOptions = getPickUpOptions()

    init {
        resetOrder()
    }

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setDate(pickUpDate: String) {
        _date.value = pickUpDate
    }

    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    private fun getPickUpOptions(): List<String> {
        val calendar = Calendar.getInstance()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())

        val options = mutableListOf<String>()
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }

        return options
    }

    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }
}