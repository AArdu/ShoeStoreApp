package com.outlook.alessandroardu.shoestore.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.outlook.alessandroardu.shoestore.R
import com.outlook.alessandroardu.shoestore.databinding.InstructionsScreenBinding

class InstructionsFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InstructionsScreenBinding =
            DataBindingUtil.inflate(inflater, R.layout.instructions_screen, container, false)
        binding.goShopButton.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(
                    InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
                )
        }
        return binding.root
    }
}