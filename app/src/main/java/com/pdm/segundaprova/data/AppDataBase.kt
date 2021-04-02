package com.pdm.segundaprova.data


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Veiculo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun veiculoDao(): VeiculoDAO
}