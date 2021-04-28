package com.pdm.segundaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.pdm.segundaprova.model.Veiculo
import com.pdm.segundaprova.repository.VeiculoRepository
import com.pdm.segundaprova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)


            val v1 = Veiculo(0, "Prisma", "Prata", 2017,
                40000f, 10, true)
            val v2 = Veiculo(0, "Celta", "Preto", 2010,
                12000f, 18, true)
            val v3 = Veiculo(0, "Voyage", "Branco", 2014,
                50000f, 3, false)
            val v4 = Veiculo(0, "Jetta", "Vermelho", 2020,
                80000f, 0, false)
            with(VeiculoRepository(this).getDB()){
                inserir(v1)
                inserir(v2)
                inserir(v3)
                inserir(v4)
            }


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
    }

}