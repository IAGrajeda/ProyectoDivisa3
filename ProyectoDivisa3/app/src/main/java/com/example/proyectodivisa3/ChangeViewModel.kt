package com.example.proyectodivisa3

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.proyectodivisa3.Exchange

class changViewModel(private val repositoryCambio: ChangeRepository) : ViewModel() {
    val allExchange : LiveData<List<Exchange>> = repositoryCambio.allExchange.asLiveData()
}

class ChangeViewModelFactory(private val repositoryCambio: ChangeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(changViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return changViewModel(repositoryCambio ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}