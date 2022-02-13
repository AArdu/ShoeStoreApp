package com.outlook.alessandroardu.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.outlook.alessandroardu.shoestore.R
import com.outlook.alessandroardu.shoestore.SharedViewModel
import com.outlook.alessandroardu.shoestore.databinding.ShoeDetailsScreenBinding

class ShoeDetailsFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: ShoeDetailsScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_details_screen,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // INOTE pass new shoe item to sahred view model
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.saveShoeButton.setOnClickListener { v: View ->
            val newShoeItem = Shoe(
                binding.shoeNameEditText.text.toString(),
                binding.shoeSizeEditText.text.toString(),
                binding.shoeCompanyEditText.text.toString(),
                binding.shoeDescriptionEditText.text.toString()
            )
            viewModel.appendShoes(newShoeItem)
            v.findNavController()
                .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }

        // go to list fragment without saving new item
        binding.cancelButton.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }
    }
}