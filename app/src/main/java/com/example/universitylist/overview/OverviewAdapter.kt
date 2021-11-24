package com.example.universitylist.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.universitylist.databinding.UniversityItemBinding
import com.example.universitylist.network.University

class OverviewAdapter( val onclick : (University) -> Unit ) : ListAdapter<University, OverviewAdapter.UniversityViewHolder>(UniversityComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val view = UniversityItemBinding.inflate( LayoutInflater.from( parent.context ) )
        return UniversityViewHolder(view)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        holder.bind( getItem(position) )
        holder.itemView.setOnClickListener {
            onclick( getItem(position))
        }
    }


    class UniversityViewHolder( private var binding : UniversityItemBinding ) : RecyclerView.ViewHolder(binding.root) {

        fun bind( university : University? ){
            binding.university = university
            binding.executePendingBindings()
        }
    }

   companion object UniversityComparator : DiffUtil.ItemCallback<University>(){
       override fun areItemsTheSame(oldItem: University, newItem: University): Boolean =
           oldItem.name === newItem.name

       override fun areContentsTheSame(oldItem: University, newItem: University): Boolean =
           oldItem.name == newItem.name

   }
}