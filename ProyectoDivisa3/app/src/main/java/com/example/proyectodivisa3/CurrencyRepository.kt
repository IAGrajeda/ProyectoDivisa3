package com.example.proyectodivisa3

import com.example.proyectodivisa3.Currency
import com.example.proyectodivisa3.CurrencyDao
import kotlinx.coroutines.flow.Flow

class CurrencyRepository(private val currencyDao: CurrencyDao) {
    val allMonedas: Flow<List<Currency>>
        get() = currencyDao.getAll()
}