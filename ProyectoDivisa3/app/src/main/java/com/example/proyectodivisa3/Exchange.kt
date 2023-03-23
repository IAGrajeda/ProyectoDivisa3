package com.example.proyectodivisa3

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Exchange (
    @PrimaryKey(autoGenerate = true)
    val  _ID: Int,
    val codeCurrencyExchange: String,
    val currency: String,
    val dateActualization: String,
    val dateConsult: String

)