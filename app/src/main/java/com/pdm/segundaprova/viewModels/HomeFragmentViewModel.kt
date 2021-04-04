package com.pdm.segundaprova.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.pdm.segundaprova.data.AppDatabase
import com.pdm.segundaprova.data.Veiculo

class HomeFragmentViewModel(application : Application) : AndroidViewModel(application) {

    var list: LiveData<List<Veiculo>>

    init{
        val db: AppDatabase by lazy {
            Room.databaseBuilder(
                application.applicationContext,
                AppDatabase::class.java, "veiculos-database")
                .allowMainThreadQueries()
                .build()
        }

        list = db.veiculoDao().listAll()
    }

}