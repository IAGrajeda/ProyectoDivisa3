package com.example.proyectodivisa3

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.proyectodivisa3.Currency

class CurrencyViewModel(private val repositoryMoneda: CurrencyRepository) : ViewModel() {
    val allCurrency : LiveData<List<Currency>> = repositoryMoneda.allMonedas.asLiveData()
}

class CurrencyViewModelFactory(private val repositoryCurrency: CurrencyRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CurrencyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CurrencyViewModel(repositoryCurrency ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}