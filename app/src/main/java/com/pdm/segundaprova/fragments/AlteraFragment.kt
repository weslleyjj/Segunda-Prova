package com.pdm.segundaprova.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.pdm.segundaprova.DialogFragmentMessage
import com.pdm.segundaprova.R
import com.pdm.segundaprova.data.Veiculo
import com.pdm.segundaprova.data.VeiculoRepository
import com.pdm.segundaprova.databinding.AlteraFragmentBinding
import com.pdm.segundaprova.databinding.FragmentCadastraBinding
import com.pdm.segundaprova.viewModels.CadastraFragmentViewModel

class AlteraFragment : Fragment(){

    lateinit var binding : AlteraFragmentBinding
    lateinit var repository : VeiculoRepository
    lateinit var veiculo : Veiculo

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.altera_fragment, container, false)
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


        binding.salvar.setOnClickListener {

            with(veiculo){
                modelo = binding.modeloEdit.text.toString()
                cor = binding.corEdit.text.toString()
                ano =  binding.anoEdit.text.toString().toInt()
                estoque =  binding.estoqueEdit.text.toString().toInt()
                preco =  binding.precoEdit.text.toString().toFloat()
                prontaEntrega =  binding.pEntregaId.isChecked
            }

            repository.getDB().veiculoDao().atualizar(veiculo)
            Navigation.findNavController(it).navigate(R.id.action_alteraFragment_to_homeFragment)

        }

        binding.cancelar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_alteraFragment_to_homeFragment)
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
                b.putString("titulo", "Alterar dados do veículo")
                b.putString("texto", "Escolha os campos de sua preferência para fazer as edições no cadastro do veículo" +
                        "\n\nClique em 'Cancelar' para retornar a página inicial e não editar o veículo")
                val dialog = DialogFragmentMessage(b)
                dialog.show(childFragmentManager,"Dialog")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}