package com.pdm.segundaprova.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_veiculo")
data class Veiculo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var modelo: String = "",
    var cor: String = "",
    var ano: Int = 0,
    var preco: Float = 0f,
    var estoque: Int = 0,
    @ColumnInfo(name = "pronta_entrega")
    var prontaEntrega: Boolean = false

) {

}