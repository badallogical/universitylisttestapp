package com.example.universitylist

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.universitylist.overview.OverviewAdapter
import com.example.universitylist.network.University

@BindingAdapter( "setUniversities")
fun bindUniversities( recyclerView: RecyclerView , list : List<University>? ){
    var adapter = recyclerView.adapter as OverviewAdapter
    adapter.submitList(list)
    Log.d("adapter", "called")
}