package com.pdm.segundaprova.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdm.segundaprova.R
import com.pdm.segundaprova.adapters.RecyclerAdapter
import com.pdm.segundaprova.data.Veiculo
import com.pdm.segundaprova.viewModels.CadastraFragmentViewModel
import com.pdm.segundaprova.viewModels.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.Observer

class CadastraFragment : Fragment(){

    lateinit var viewModel: CadastraFragmentViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewModel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)

        with(viewModel.dados){
            //Implementar vínculo do viewmodel com os dados do form
        }

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}