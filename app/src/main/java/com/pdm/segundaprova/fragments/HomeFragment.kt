package com.pdm.segundaprova.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdm.segundaprova.R
import com.pdm.segundaprova.adapters.RecyclerAdapter
import com.pdm.segundaprova.data.Veiculo
import com.pdm.segundaprova.viewModels.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*



class HomeFragment : Fragment() {

    lateinit var viewModel: HomeFragmentViewModel
    val adapterHome = RecyclerAdapter()
    lateinit var layout: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapterHome.veiculos = it as MutableList<Veiculo>
            adapterHome.notifyDataSetChanged()
        })

        layout = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recycler_view.apply {

            layoutManager = layout
            adapter = adapterHome

        }
    }

}