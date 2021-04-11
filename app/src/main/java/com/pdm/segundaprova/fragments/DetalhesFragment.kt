package com.pdm.segundaprova.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.pdm.segundaprova.DialogFragmentMessage
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
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.title){
            "Ajuda" -> {
                val b = Bundle()
                b.putString("titulo", "Detalhes do veículo")
                b.putString("texto", "Nesta tela você tem acesso a visualização de todos os dados do veículo" +
                        "\n\nCaso deseje mudar alguma informação basta tocar no botão de Editar")
                val dialog = DialogFragmentMessage(b)
                dialog.show(childFragmentManager,"Dialog")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}