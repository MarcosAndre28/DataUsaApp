package com.example.datausaapp.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datausaapp.R
import com.example.datausaapp.data.api.ApiClientInstance
import com.example.datausaapp.data.repository.StateRepository
import com.example.datausaapp.view.FragmentStateViewModel


class StatesFragment : Fragment() {

    private lateinit var viewModel: FragmentStateViewModel.RecipeDetailsViewModel
    private var getApiInstance = ApiClientInstance.retrofitInstance
    private var repositorya = StateRepository(getApiInstance)
    private var cityAdapter = StatesAdapter {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, EditStatesFragment(it) {
                viewModel.updateState(it)
            })
            ?.addToBackStack(null)
            ?.commit()
    }
    lateinit var ctCv: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ctCv = view.findViewById(R.id.rv_citys)

        setupViewModel()
        setRecyclerView()



        viewModel.states.observe(requireActivity()) {
            cityAdapter.setupRecycleView(it)
        }
        viewModel.states
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_city, container, false)


    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            FragmentStateViewModel.RecipeDetailsViewModel.RecipeDetailViewModelFactory(
                repositorya
            )
        ).get(FragmentStateViewModel.RecipeDetailsViewModel::class.java)
    }

    private fun setRecyclerView() {

        val layoutManager = LinearLayoutManager(context)

        ctCv.layoutManager = layoutManager
        ctCv.adapter = cityAdapter
        DividerItemDecoration(
            requireContext(),
            layoutManager.orientation
        ).apply {

            ctCv.addItemDecoration(this)
        }
    }
}