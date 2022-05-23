package com.example.worldTour.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.worldTour.R
import com.example.worldTour.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    private  val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.showButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }
        return binding.root
    }
}