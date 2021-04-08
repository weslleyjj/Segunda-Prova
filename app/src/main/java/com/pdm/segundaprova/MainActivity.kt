package com.pdm.segundaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.pdm.segundaprova.data.AppDatabase
import com.pdm.segundaprova.data.Veiculo
import com.pdm.segundaprova.fragments.CadastraFragment

class MainActivity : AppCompatActivity() {

    private lateinit var customBar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customBar = findViewById(R.id.customActionBar)

        this.setSupportActionBar(customBar)


        /*
        val v1 = Veiculo(0, "Prisma", "Prata", 2017,
            40000f, 10, true)

        val v2 = Veiculo(0, "Celta", "Preto", 2010,
            12000f, 18, true)

        val v3 = Veiculo(0, "Voyage", "Branco", 2014,
            50000f, 3, false)

        val v4 = Veiculo(0, "Jetta", "Vermelho", 2020,
            80000f, 0, false)

        with(db.veiculoDao()){
            inserir(v1)
            inserir(v2)
            inserir(v3)
            inserir(v4)

        }*/

    }

    //Fazer utilização do banco com corrotinas do kotlin no lugar de asyncTask

}