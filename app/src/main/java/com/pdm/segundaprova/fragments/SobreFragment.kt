package com.pdm.segundaprova.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdm.segundaprova.R
import com.pdm.segundaprova.adapters.RecyclerAdapter
import com.pdm.segundaprova.data.Veiculo
import com.pdm.segundaprova.databinding.FragmentSobreBinding
import com.pdm.segundaprova.viewModels.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class SobreFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_sobre, container, false)

    }

}