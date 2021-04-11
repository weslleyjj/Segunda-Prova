package com.pdm.segundaprova.data

import android.content.Context
import androidx.room.Room

open class VeiculoRepository(context: Context) {

    val db: AppDatabase by lazy {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "veiculos-database")
            .allowMainThreadQueries()
            .build()
    }

    open fun getDB() : VeiculoDAO{
        return db.veiculoDao();
    }

}