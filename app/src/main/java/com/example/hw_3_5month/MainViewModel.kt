package com.example.hw_3_5month

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val counter_ = MutableLiveData<Int>()

    val counterLD: LiveData<Int> = counter_

    private var counter = 0

    init {
        counter_.value = counter
    }

    fun increment() {
        counter++
        counter_.value = counter
    }

    fun decrement() {
        counter--
        counter_.value = counter
    }
}