package com.pdm.segundaprova.ui.altera

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class AlteraVeiculoViewModel(application: Application): AndroidViewModel(application) {

    private var _eventAlteraVeiculo = MutableLiveData<Boolean>(false)
    val eventAlteraVeiculo : LiveData<Boolean>
        get() = _eventAlteraVeiculo


    fun alteraVeiculo(){
        _eventAlteraVeiculo.value = true
    }

    fun onAlteraVeiculoComplete(){
        _eventAlteraVeiculo.value = false
    }

}