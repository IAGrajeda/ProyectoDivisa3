package com.example.proyectodivisa3cliente

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Spinner
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader


class MainActivity : AppCompatActivity() {
    val mLoaderCallbacks = object : LoaderManager.LoaderCallbacks<Cursor>{
        override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
            return CursorLoader(
                applicationContext,
                Uri.parse("content://com.example.proyectodivisa3/cambios"),
                arrayOf<String>("_ID", "codeCurrencyExchange","currency","dateActualization","dateConsult"),
                null, null, null)
        }

        override fun onLoaderReset(loader: Loader<Cursor>) {}
        override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
            val adapter = SimpleCursorAdapter(applicationContext,
                R.layout.item_list,data,
                arrayOf<String>("_ID","currency","codeCurrencyExchange","dateActualization","dateConsult"),
                IntArray(5).apply {
                    set(1, R.id.text1)
                    set(2, R.id.text2)
                    set(3, R.id.text3)
                    set(4, R.id.text4)
                },
                SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE
            )
            val listView: ListView = findViewById(R.id.list_view)
            listView.adapter = adapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoaderManager.getInstance(this)
            .initLoader<Cursor>(1001, null, mLoaderCallbacks)
    }
}