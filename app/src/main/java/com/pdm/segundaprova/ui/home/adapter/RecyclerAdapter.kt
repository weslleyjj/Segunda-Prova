package com.pdm.segundaprova.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pdm.segundaprova.R
import com.pdm.segundaprova.model.Veiculo
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.pdm.segundaprova.ui.home.HomeFragmentDirections
import com.pdm.segundaprova.ui.home.adapter.RecyclerAdapter.ViewHolder.Companion.from

class RecyclerAdapter : ListAdapter<Veiculo, RecyclerAdapter.ViewHolder>(VeiculoDiffCallBack()) {

    // Após a criação do viewHolder é feito a atribuição do home_fragment_Cards como view a ser repetida para cada informação
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder.from(this, viewGroup)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val veiculo = getItem(i)
        viewHolder.bind(veiculo)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //Dados que serão exibidos no card, exceto o dado id
        var modelo: TextView
        var ano: TextView
        var preco: TextView
        var id = 0

        init {
            modelo = itemView.findViewById(R.id.modeloVeiculo)
            ano = itemView.findViewById(R.id.anoVeiculo)
            preco = itemView.findViewById(R.id.precoVeiculo)

            itemView.setOnClickListener {
                Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(id))
            }
            itemView.setOnLongClickListener {
                Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(id))
                return@setOnLongClickListener true
            }
        }

        fun bind(veiculo: Veiculo) {
            id = veiculo.id
            modelo.text = veiculo.modelo
            ano.text = veiculo.ano.toString()
            preco.text = veiculo.preco.toString()
        }

        companion object {
            fun from(recyclerAdapter: RecyclerAdapter, viewGroup: ViewGroup): ViewHolder {
                val v = LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.home_fragment_cards, viewGroup, false)
                return ViewHolder(v)
            }
        }
    }

}

class VeiculoDiffCallBack : DiffUtil.ItemCallback<Veiculo>(){
    override fun areItemsTheSame(oldItem: Veiculo, newItem: Veiculo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Veiculo, newItem: Veiculo): Boolean {
        return oldItem == newItem
    }

}