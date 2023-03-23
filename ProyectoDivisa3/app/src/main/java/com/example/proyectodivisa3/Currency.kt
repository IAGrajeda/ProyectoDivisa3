package com.example.proyectodivisa3

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Currency (
    @PrimaryKey(autoGenerate = true)
    val  _ID: Int,
    val codeChange: String,
    val nameChange: String,
    val pais : String
)