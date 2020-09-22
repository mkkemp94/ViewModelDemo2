package com.mkemp.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Double) : ViewModel()
{
    private var total = MutableLiveData<Double>()
    val totalData: LiveData<Double> get() = total

    init {
        total.value = startingTotal
    }

    fun setTotal(amount: Double) {
        total.value = (total.value)?.plus(amount)
    }
}