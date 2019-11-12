package com.kotlin.marsrealestate.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.kotlin.marsrealestate.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentDetailBinding.inflate(inflater)

        val application = activity!!.application
        val args = DetailFragmentArgs.fromBundle(arguments!!)

        val viewModelFactory = DetailViewModelFactory(args.selectedProperty, application)

        val detailViewModel = ViewModelProviders.of(
                this, viewModelFactory).get(DetailViewModel::class.java)
        binding.viewModel = detailViewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
