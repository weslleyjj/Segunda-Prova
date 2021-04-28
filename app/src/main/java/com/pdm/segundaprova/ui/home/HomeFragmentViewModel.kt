package com.pdm.segundaprova.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.pdm.segundaprova.model.Veiculo
import com.pdm.segundaprova.repository.VeiculoRepository

class HomeFragmentViewModel(application : Application) : AndroidViewModel(application) {

    private var mlist: LiveData<List<Veiculo>>
    var list : LiveData<List<Veiculo>>


    init{
        mlist = VeiculoRepository(application).getDB().listAll()
        list = mlist
    }

}