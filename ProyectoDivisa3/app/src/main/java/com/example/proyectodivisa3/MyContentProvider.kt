package com.example.proyectodivisa3

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.proyectodivisa3.MyApplication
import com.example.proyectodivisa3.ExchangeDatabase

private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {

    addURI("com.example.proyectodivisa3", "cambios", 1)
    addURI("com.example.proyectodivisa3", "cambios/#", 2)
    addURI("com.example.proyectodivisa3", "cambios/*", 3)
}

class MyContentProvider : ContentProvider() {
    private lateinit var db: ExchangeDatabase

    override fun onCreate(): Boolean {
        db = (context as MyApplication).database
        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        var cursor: Cursor? = null
        when( sUriMatcher.match(p0)){
            1 -> {
                cursor =  db.exchangeDao().getAllCambioCursor()
            }
            else -> {}
        }
        return cursor
    }

    override fun getType(p0: Uri): String? {
        var typeMime: String = "vnd.android.cursor.dir/vnd.com.example.provider.cambios"
        when( sUriMatcher.match(p0)){
            1 -> {
                typeMime = "vnd.android.cursor.dir/vnd.com.example.provider.cambios"
            }
            2 -> {
                typeMime = "vnd.android.cursor.item/vnd.com.example.provider.cambios"
            }
            3 -> {
                typeMime = "vnd.android.cursor.item/vnd.com.example.provider.cambios"
            }
            else -> {
            }

        }
        return  typeMime
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        when( sUriMatcher.match(p0)){
            1 -> {
            }
            2 -> {

            }
            3 -> {

            }
            else -> {

            }

        }
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        when( sUriMatcher.match(p0)){

            1 -> {
            }
            2 -> {

            }
            3 -> {
            }
            else -> {

            }

        }
        return  0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        when( sUriMatcher.match(p0)){

            1 -> {
            }

            2 -> {

            }


            3 -> {
            }
            else -> {

            }

        }
        return  0
    }

}
