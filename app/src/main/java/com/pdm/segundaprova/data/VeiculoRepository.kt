package com.pdm.segundaprova.data

import android.content.Context
import androidx.room.Room

class VeiculoRepository(context: Context) {

    private val db: AppDatabase by lazy {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "veiculos-database")
            .allowMainThreadQueries()
            .build()
    }

    fun getDB() : AppDatabase{
        return db;
    }

}