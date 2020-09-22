package com.mkemp.viewmodeldemo2

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Double) : ViewModel()
{
    private var sum: Double = 0.0

    init {
        sum = startingTotal
    }

    fun getSum(): Double {
        return sum
    }

    fun addToSum(amount: Double) {
        sum += amount
    }
}