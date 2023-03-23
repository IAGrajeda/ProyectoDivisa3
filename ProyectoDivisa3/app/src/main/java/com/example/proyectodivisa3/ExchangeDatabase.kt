package com.example.proyectodivisa3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = arrayOf(Currency::class,Exchange::class), version = 1)
abstract class  ExchangeDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
    abstract fun exchangeDao(): ExchangeDao

    private class ExchangeDatabaseCallback(private val scope: CoroutineScope)
        : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { database ->
                scope.launch (Dispatchers.IO){
                    var monedaDao = database.currencyDao()

                    // Delete all content here.
                    monedaDao.deleteAll()



                }
            }

        }
    }

    companion object{
        @Volatile
        private var INSTANCE: ExchangeDatabase?=null

        val databaseexecutor :
                ExecutorService =
            Executors.newFixedThreadPool(4)

        fun getDatabase(context: Context, scope: CoroutineScope): ExchangeDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context, ExchangeDatabase::class.java,
                    "midbmonedas"
                ).addCallback(ExchangeDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}