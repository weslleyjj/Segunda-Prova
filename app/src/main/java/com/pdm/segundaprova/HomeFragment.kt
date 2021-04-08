package com.pdm.segundaprova


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        // Inflate the layout for this fragment

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
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = layout
            // set the custom adapter to the RecyclerView
            adapter = adapterHome

        }
    }

}