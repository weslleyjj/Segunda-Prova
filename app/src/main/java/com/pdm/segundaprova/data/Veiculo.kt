package com.pdm.segundaprova.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_veiculo")
data class Veiculo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val modelo: String = "",
    val cor: String = "",
    val ano: Int = 0,
    val preco: Float = 0f,
    val estoque: Int = 0,
    @ColumnInfo(name = "pronta_entrega")
    val prontaEntrega: Boolean = false

) {

}