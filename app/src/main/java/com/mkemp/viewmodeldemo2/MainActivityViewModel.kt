package com.mkemp.viewmodeldemo2

import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Double) : ViewModel(), Observable
{
    private var total = MutableLiveData<Double>()
    val totalData: LiveData<Double>
        get() = total

    @Bindable
    val inputText = MutableLiveData<String>()

    init {
        total.value = startingTotal
    }

    fun setTotal() {
        val text: String? = inputText.value.toString()
        val amount: Double = text?.toDouble() ?: 0.0
        total.value = (total.value)?.plus(amount)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}