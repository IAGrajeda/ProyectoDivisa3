package com.example.proyectodivisa3

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CurrencyDao {

    @Insert
    suspend fun insertar(currency: Currency)

    @Query("select * from Currency")
    fun getAll(): kotlinx.coroutines.flow.Flow<List<Currency>>

    @Query("DELETE FROM Currency")
    fun deleteAll() : Int

}