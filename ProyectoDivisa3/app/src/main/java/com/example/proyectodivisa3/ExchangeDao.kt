package com.example.proyectodivisa3

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExchangeDao {

    @Insert
    suspend fun insert(exchange: Exchange)

    @Query("select * from Exchange")
    fun getAll(): kotlinx.coroutines.flow.Flow<List<Exchange>>

    @Query("DELETE FROM Exchange")
    fun deleteAll() : Int

    @Query("select * from Exchange order by codeCurrencyExchange")
    fun getAllCambioCursor(): Cursor


}