package com.example.proyectodivisa3

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.proyectodivisa3.MyApplication
import com.example.proyectodivisa3.Exchange
import com.example.proyectodivisa3.ExchangeDatabase
import com.example.proyectodivisa3.CambioApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime

val TAG ="WORKER"
private lateinit var db: ExchangeDatabase
@RequiresApi(Build.VERSION_CODES.O)
val currentDate = LocalDateTime.now()
class saveWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun doWork(): Result {

        return try {
            GlobalScope.launch {
                db = (applicationContext as MyApplication).database
                try {
                    val response = CambioApi.retrofitService.getCambioApi()

                    for ((key, value) in response.rates) {
                        db.exchangeDao().insert(Exchange(0,key,value.toString(), response.time_last_update_utc,
                            currentDate.toString()))
                        println("Clave: $key Valor: $value")
                    }
                    println("Ultima actualización: ${response.time_last_update_utc}")
                } catch (e: Exception) {

                }
            }

            Result.success()
        } catch (throwable: Throwable) {
            Log.e(TAG, "Error applying blur")
            throwable.printStackTrace()
            Result.failure()
        }
    }
}