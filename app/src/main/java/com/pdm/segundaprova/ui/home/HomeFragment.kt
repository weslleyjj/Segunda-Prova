package com.pdm.segundaprova.ui.home


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdm.segundaprova.dialogs.DialogFragmentMessage
import com.pdm.segundaprova.R
import com.pdm.segundaprova.ui.home.adapter.RecyclerAdapter
import com.pdm.segundaprova.model.Veiculo
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
            adapterHome.submitList(it)
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
        return super.onOptionsItemSelected(item)
    }

}