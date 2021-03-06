package com.outlook.alessandroardu.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.outlook.alessandroardu.shoestore.R
import com.outlook.alessandroardu.shoestore.SharedViewModel
import com.outlook.alessandroardu.shoestore.databinding.NewShoeListingViewBinding
import com.outlook.alessandroardu.shoestore.databinding.ShoeListScreenBinding
import timber.log.Timber

class ShoeListFragment() : Fragment() {
    // INOTE Create a class that extends ViewModel
    private lateinit var binding: ShoeListScreenBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_list_screen,
            container,
            false
        )


        // INOTE floating action button to add new shoe item
        binding.addShoeButton.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        addNewView()

        return binding.root

    }


    fun addNewView() {
        // INOTE solution taken from
        //  https://blog.mindorks.com/shared-viewmodel-in-android-shared-between-fragments
        // INOTE instantiate SharedViewModel
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // get update on items in shoe list
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach { shoeItem ->
                val listingTxt = getString(R.string.shoe_listing_text).format(
                    shoeItem.name,
                    shoeItem.company,
                    shoeItem.size,
                    shoeItem.description
                )

                // create a new view binding for each item
                val newShoeBinding = NewShoeListingViewBinding.inflate(
                    LayoutInflater.from(requireContext()),
                    binding.listingsParentLayout,
                    false
                )

                newShoeBinding.newShoeListing.text = listingTxt
                // add view to parent layout
                binding.listingsParentLayout.addView(newShoeBinding.root)

            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INOTE add logout overfow menu
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return true
    }
}
