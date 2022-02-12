package com.outlook.alessandroardu.shoestore.screens.welcome

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.outlook.alessandroardu.shoestore.R
import com.outlook.alessandroardu.shoestore.databinding.WelcomeScreenBinding
import timber.log.Timber

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i("welcomeFragment", "item.toString()")
        return NavigationUI.onNavDestinationSelected(
            item!!,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}