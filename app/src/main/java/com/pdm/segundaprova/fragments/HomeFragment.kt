package com.pdm.segundaprova.fragments


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdm.segundaprova.DialogFragmentMessage
import com.pdm.segundaprova.R
import com.pdm.segundaprova.adapters.RecyclerAdapter
import com.pdm.segundaprova.data.Veiculo
import com.pdm.segundaprova.viewModels.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*



class HomeFragment : Fragment() {

    lateinit var viewModel: HomeFragmentViewModel
    val adapterHome = RecyclerAdapter()
    lateinit var layout: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapterHome.veiculos = it as MutableList<Veiculo>
            adapterHome.notifyDataSetChanged()
        })

        layout = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recycler_view.apply {

            layoutManager = layout
            adapter = adapterHome

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.title){
            "Ajuda" -> {
                val b = Bundle()
                b.putString("titulo", "Página Inicial")
                b.putString("texto", "Navegue por esta tela para visualizar todos os veículos cadastrados" +
                        "\n\n\n Segure por um tempo para editar o veiculo\n\n\n Toque simples irá mostrar mais detalhes")
                val dialog = DialogFragmentMessage(b)
                dialog.show(childFragmentManager,"Dialog")
            }
        }
        return super.onOptionsItemSelected(item)}

}