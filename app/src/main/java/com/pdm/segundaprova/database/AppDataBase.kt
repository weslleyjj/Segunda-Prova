package com.pdm.segundaprova.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.pdm.segundaprova.model.Veiculo

@Database(entities = [Veiculo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun veiculoDao(): VeiculoDAO
}