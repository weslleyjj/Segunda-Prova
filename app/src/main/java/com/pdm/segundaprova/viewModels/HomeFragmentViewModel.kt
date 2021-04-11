package com.pdm.segundaprova.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.pdm.segundaprova.data.AppDatabase
import com.pdm.segundaprova.data.Veiculo
import com.pdm.segundaprova.data.VeiculoRepository

class HomeFragmentViewModel(application : Application) : AndroidViewModel(application) {

    private var mlist: LiveData<List<Veiculo>>
    var list : LiveData<List<Veiculo>>


    init{
        mlist = VeiculoRepository(application).getDB().listAll()
        list = mlist
    }

}