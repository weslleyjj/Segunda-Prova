package com.pdm.segundaprova.data

import android.content.Context
import androidx.room.Room

//Open para que se possa usar o repository de maneira estática entre os fragments
open class VeiculoRepository(context: Context) {

    val db: AppDatabase by lazy {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "veiculos-database")
            .allowMainThreadQueries()
            .build()
    }

    //Método para obtenção de acesso ao db
    open fun getDB() : VeiculoDAO{
        return db.veiculoDao();
    }

}