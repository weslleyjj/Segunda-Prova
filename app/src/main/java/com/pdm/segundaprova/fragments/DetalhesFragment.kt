package com.pdm.segundaprova.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.pdm.segundaprova.R
import com.pdm.segundaprova.data.Veiculo
import com.pdm.segundaprova.data.VeiculoRepository
import com.pdm.segundaprova.databinding.AlteraFragmentBinding
import com.pdm.segundaprova.databinding.FragmentDetalhesBinding

class DetalhesFragment  : Fragment(){

    lateinit var binding : FragmentDetalhesBinding
    lateinit var repository : VeiculoRepository
    lateinit var veiculo : Veiculo

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        repository = VeiculoRepository(inflater.context)

        val args = AlteraFragmentArgs.fromBundle(requireArguments())

        veiculo = repository.getDB().veiculoDao().findById(args.idVeiculo)

        with(binding){
            modeloEdit.setText(veiculo.modelo)
            corEdit.setText(veiculo.cor)
            anoEdit.setText(veiculo.ano.toString())
            precoEdit.setText(veiculo.preco.toInt().toString())
            estoqueEdit.setText(veiculo.estoque.toString())
            pEntregaId.isChecked = veiculo.prontaEntrega
        }

        binding.voltar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_detalhesFragment_to_homeFragment)
        }

        binding.editar.setOnClickListener {
            Navigation.findNavController(it).navigate(DetalhesFragmentDirections.actionDetalhesFragmentToAlteraFragment(veiculo.id))
        }

        return binding.root
    }

}