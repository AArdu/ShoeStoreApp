package com.outlook.alessandroardu.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.outlook.alessandroardu.shoestore.R
import com.outlook.alessandroardu.shoestore.databinding.NewShoeListingViewBinding
import com.outlook.alessandroardu.shoestore.databinding.ShoeListScreenBinding
import timber.log.Timber

class ShoeListFragment() : Fragment() {
    // INOTE Create a class that extends ViewModel
    private lateinit var viewModel: ShoeListModel
    private lateinit var viewModelFactory: ShoeListModelFactory
    private lateinit var binding: ShoeListScreenBinding
    lateinit var newShoeText: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_list_screen,
            container,
            false
        )

        // INOTE get new shoe as argument from ShoeDetailsFragment
        val newShoeArg by navArgs<ShoeListFragmentArgs>()

        // INOTE Create a class that extends ViewModel
        viewModelFactory = ShoeListModelFactory(newShoeArg.newShoe, newShoeArg.shouldSave)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoeListModel::class.java)
        binding.shoeListModel = viewModel
        binding.setLifecycleOwner(this)

        // INOTE save and cancel buttons
        //  with action to navigate to the shoe detail screen
        binding.addShoeButton.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        viewModel.hasAddedViews.observe(viewLifecycleOwner, Observer { hasAddedViews ->
            if (hasAddedViews == false) {
                // TODO make it add a new view every time save is pressed: now adding only one instance
                viewModel.getShoeList()?.forEach { newShow ->
                    val newShoeBinding =
                        DataBindingUtil.inflate<NewShoeListingViewBinding>(
                            layoutInflater,
                            R.layout.new_shoe_listing_view,
                            this.view as ViewGroup?,
                            false
                        )
                    binding.listingsParentLayout.addView(newShoeBinding.root)
                }
                viewModel.addShoeComplete()
            }
        })

        return binding.root

    }

    override fun onStart() {
        super.onStart()
        viewModel.addShoeStart()
    }
}
