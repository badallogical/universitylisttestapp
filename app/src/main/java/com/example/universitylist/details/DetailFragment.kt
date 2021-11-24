package com.example.universitylist.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.universitylist.databinding.DetailsLayoutBinding

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DetailsLayoutBinding.inflate( inflater )

        binding.lifecycleOwner = this

        binding.university = DetailFragmentArgs.fromBundle( requireArguments() ).selectedUniversity

        return binding.root
    }

}
