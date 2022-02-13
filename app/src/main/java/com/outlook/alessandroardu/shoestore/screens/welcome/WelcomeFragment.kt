package com.outlook.alessandroardu.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.outlook.alessandroardu.shoestore.R
import com.outlook.alessandroardu.shoestore.databinding.WelcomeScreenBinding

class WelcomeFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WelcomeScreenBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_screen,
            container,
            false
        )

        binding.goToInstructionsButton.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())

        }

        setHasOptionsMenu(true)

        return binding.root
    }


}