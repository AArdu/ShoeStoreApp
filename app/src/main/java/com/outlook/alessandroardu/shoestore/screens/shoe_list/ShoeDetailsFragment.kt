package com.outlook.alessandroardu.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.outlook.alessandroardu.shoestore.R
import com.outlook.alessandroardu.shoestore.databinding.ShoeDetailsScreenBinding

class ShoeDetailsFragment : Fragment() {
    private lateinit var viewModel: ShoeListModel
    private lateinit var viewModelFactory: ShoeListModelFactory
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


        // INOTE pass new shoe instance in navigation action as argument for shoe list fragment
        binding.saveShoeButton.setOnClickListener { v: View ->
            val shoeName = binding.shoeNameEditText.text.toString()
            val shoeSize = binding.shoeSizeEditText.text.toString()
            val shoeDescription = binding.shoeDescriptionEditText.text.toString()
            val shoeCompany = binding.shoeCompanyEditText.text.toString()
            val shoeImages = ""
            val newShoe = Shoe(shoeName, shoeSize, shoeCompany, shoeDescription, listOf(shoeImages))
            v.findNavController().navigate(
                ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment(
                    newShoe,
                    true
                )
            )
        }

        binding.cancelButton.setOnClickListener { v: View ->
            val shoeName = binding.shoeNameEditText.text.toString()
            val shoeSize = binding.shoeSizeEditText.text.toString()
            val shoeDescription = binding.shoeDescriptionEditText.text.toString()
            val shoeCompany = binding.shoeCompanyEditText.text.toString()
            val shoeImages = ""
            val newShoe = Shoe(shoeName, shoeSize, shoeCompany, shoeDescription, listOf(shoeImages))
            v.findNavController().navigate(
                ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment(
                    newShoe,
                    false
                )
            )

        }

        return binding.root
    }

}