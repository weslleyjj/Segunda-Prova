package com.pdm.segundaprova.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.pdm.segundaprova.data.AppDatabase
import com.pdm.segundaprova.data.Veiculo

class HomeFragmentViewModel(application : Application) : AndroidViewModel(application) {

    private lateinit var mlist: LiveData<List<Veiculo>>
    lateinit var list : LiveData<List<Veiculo>>


    init{
        val db: AppDatabase by lazy {
            Room.databaseBuilder(
                application.applicationContext,
                AppDatabase::class.java, "veiculos-database")
                .allowMainThreadQueries()
                .build()
        }
        mlist = db.veiculoDao().listAll()
        list = mlist
    }

}