package com.pdm.segundaprova

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.pdm.segundaprova.data.Veiculo

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var veiculos = mutableListOf<Veiculo>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var modelo: TextView
        var ano: TextView
        var preco: TextView

        init {
            modelo = itemView.findViewById(R.id.modeloVeiculo)
            ano = itemView.findViewById(R.id.anoVeiculo)
            preco = itemView.findViewById(R.id.precoVeiculo)

            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val context = itemView.context
                val intent = Intent(context, MainActivity::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", modelo.text)
                    putExtra("CATEGORY", ano.text)
                    putExtra("CONTENT", preco.text)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.home_fragment_cards, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.modelo.text = veiculos[i].modelo
        viewHolder.ano.text = veiculos[i].ano.toString()
        viewHolder.preco.text = veiculos[i].preco.toString()
    }

    override fun getItemCount(): Int {
        return veiculos.size
    }
}