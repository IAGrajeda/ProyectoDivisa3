package com.example.proyectodivisa3

import com.example.proyectodivisa3.Exchange
import com.example.proyectodivisa3.ExchangeDao
import kotlinx.coroutines.flow.Flow

class ChangeRepository (private val exchangeDao: ExchangeDao) {
    val allExchange: Flow<List<Exchange>>
        get() = exchangeDao.getAll()
}

