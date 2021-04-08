package com.pdm.segundaprova.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdm.segundaprova.R
import com.pdm.segundaprova.adapters.RecyclerAdapter
import com.pdm.segundaprova.data.Veiculo
import com.pdm.segundaprova.data.VeiculoRepository
import com.pdm.segundaprova.databinding.FragmentCadastraBinding
import com.pdm.segundaprova.viewModels.CadastraFragmentViewModel
import com.pdm.segundaprova.viewModels.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.Observer

class CadastraFragment : Fragment(){

    lateinit var viewModel: CadastraFragmentViewModel
    lateinit var binding : FragmentCadastraBinding
    lateinit var repository : VeiculoRepository

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        repository = VeiculoRepository(inflater.context)

        binding.salvar.setOnClickListener {
            with(viewModel.dados){
                modelo = binding.modeloEdit.text.toString()
                cor = binding.corEdit.text.toString()
                ano =  binding.anoEdit.text.toString().toInt()
                estoque =  binding.estoqueEdit.text.toString().toInt()
                preco =  binding.anoEdit.text.toString().toFloat()
                prontaEntrega =  binding.pEntregaId.isChecked
            }
            repository.getDB().veiculoDao().inserir(viewModel.dados)
            Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)

        }

        binding.cancelar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)
        }

        return binding.root
    }

}