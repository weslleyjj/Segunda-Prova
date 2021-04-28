package com.pdm.segundaprova.ui.cadastra;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pdm.segundaprova.model.Veiculo

public class CadastraVeiculoViewModel (application :Application) : AndroidViewModel(application) {

        lateinit var dados : Veiculo
        private var _eventCadastraVeiculo = MutableLiveData<Boolean>(false)
        val eventCadastraVeiculo : LiveData<Boolean>
                get() = _eventCadastraVeiculo

        init{
                dados = Veiculo()
        }

        fun cadastraVeiculo(){
                _eventCadastraVeiculo.value = true
        }

        fun onCadastraVeiculoComplete(){
                _eventCadastraVeiculo.value = false
        }

}