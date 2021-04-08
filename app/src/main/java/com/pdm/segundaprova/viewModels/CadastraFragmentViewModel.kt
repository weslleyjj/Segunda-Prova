package com.pdm.segundaprova.viewModels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel
import com.pdm.segundaprova.data.Veiculo

public class CadastraFragmentViewModel (application :Application) : AndroidViewModel(application) {

        lateinit var dados : Veiculo

        init{
                dados = Veiculo()
        }


}