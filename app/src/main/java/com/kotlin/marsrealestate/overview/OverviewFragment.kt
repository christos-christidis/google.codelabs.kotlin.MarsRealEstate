package com.kotlin.marsrealestate.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.kotlin.marsrealestate.R
import com.kotlin.marsrealestate.databinding.FragmentOverviewBinding
import com.kotlin.marsrealestate.network.MarsApiFilter

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProviders.of(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.photosGrid.adapter = PhotoGridAdapter {
            findNavController().navigate(
                    OverviewFragmentDirections.actionShowDetail(it)
            )
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.updateFilter(when (item.itemId) {
            R.id.show_rent_menu -> MarsApiFilter.SHOW_RENT
            R.id.show_buy_menu -> MarsApiFilter.SHOW_BUY
            else -> MarsApiFilter.SHOW_ALL
        })
        return true
    }
}
