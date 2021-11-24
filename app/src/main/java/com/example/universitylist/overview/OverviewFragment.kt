package com.example.universitylist.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.universitylist.databinding.OverviewLayoutBinding
import com.example.universitylist.databinding.UniversityItemBinding
import com.example.universitylist.network.University

class OverviewFragment( ) : Fragment() {

    private val viewModel : OverviewViewModel by lazy {
        ViewModelProvider( this ).get( OverviewViewModel::class.java )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = OverviewLayoutBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.universityList.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

        binding.search.setOnQueryTextListener( object : OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                if( query != null ){
                    viewModel.getUniversities(query)
                }
                return true;
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true;
            }

        })

        val navController = NavHostFragment.findNavController(this)

        val navigateToDetails : ( University ) -> Unit = {  university : University ->
                navController.navigate( OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(university) )
        }

        binding.universityList.adapter = OverviewAdapter( navigateToDetails )

        return binding.root
    }

}