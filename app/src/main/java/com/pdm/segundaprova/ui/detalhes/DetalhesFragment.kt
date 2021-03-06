package com.pdm.segundaprova.ui.detalhes

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.pdm.segundaprova.dialogs.DialogFragmentMessage
import com.pdm.segundaprova.R
import com.pdm.segundaprova.model.Veiculo
import com.pdm.segundaprova.repository.VeiculoRepository
import com.pdm.segundaprova.databinding.FragmentDetalhesBinding
import com.pdm.segundaprova.ui.altera.AlteraFragmentArgs

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

        veiculo = VeiculoRepository(inflater.context).getDB().findById(args.idVeiculo)

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
                b.putString("titulo", "Detalhes do ve??culo")
                b.putString("texto", "Nesta tela voc?? tem acesso a visualiza????o de todos os dados do ve??culo" +
                        "\n\nCaso deseje mudar alguma informa????o basta tocar no bot??o de Editar")
                val dialog = DialogFragmentMessage(b)
                dialog.show(childFragmentManager,"Dialog")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}