package com.pdm.segundaprova

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val kode = arrayOf("d116df5",
        "36ffc75", "f5cfe78", "5b87628",
        "db8d14e", "9913dc4", "e120f96",
        "466251b")

    private val kategori = arrayOf("Kekayaan", "Teknologi",
        "Keluarga", "Bisnis",
        "Keluarga", "Hutang",
        "Teknologi", "Pidana")

    private val isi = arrayOf("pertanyaan 9",
        "pertanyaan 11", "pertanyaan 17", "test forum",
        "pertanyaan 12", "pertanyaan 18", "pertanyaan 20",
        "pertanyaan 21")

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
        viewHolder.modelo.text = kode[i]
        viewHolder.ano.text = kategori[i]
        viewHolder.preco.text = isi[i]

    }

    override fun getItemCount(): Int {
        return kode.size
    }
}