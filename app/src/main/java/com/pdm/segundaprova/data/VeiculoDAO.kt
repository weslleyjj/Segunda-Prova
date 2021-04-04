package com.pdm.segundaprova.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VeiculoDAO {

    @Insert
    fun inserir(veiculo: Veiculo)

    @Delete
    fun deletar(veiculo: Veiculo): Int

    @Update
    fun atualizar(veiculo: Veiculo): Int

    @Query("SELECT * FROM tabela_veiculo")
    fun listAll(): LiveData<List<Veiculo>>

    @Query("SELECT * FROM tabela_veiculo")
    fun listAllAsArray(): Array<Veiculo>

    @Query("SELECT * FROM tabela_veiculo WHERE id = :id")
    fun findById(id: Int): Veiculo

    @Query("SELECT * FROM tabela_veiculo WHERE modelo = :modelo")
    fun findByName (modelo: String) : Veiculo
}