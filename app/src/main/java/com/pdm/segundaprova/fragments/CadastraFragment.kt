package com.pdm.segundaprova.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdm.segundaprova.DialogFragmentMessage
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
                preco =  binding.precoEdit.text.toString().toFloat()
                prontaEntrega =  binding.pEntregaId.isChecked
            }
            repository.getDB().veiculoDao().inserir(viewModel.dados)
            Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)

        }

        binding.cancelar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)
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
                b.putString("titulo", "Cadastrar veículo")
                b.putString("texto", "Preencha aqui os dados referentes ao veículo que deseja cadastrar" +
                        " \n\nApós o cadastro você será redirecionado para a tela de visualização de veículos" +
                        "\n\nClique em 'Cancelar' para retornar a página inicial e não salvar o veículo")
                val dialog = DialogFragmentMessage(b)
                dialog.show(childFragmentManager,"Dialog")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}