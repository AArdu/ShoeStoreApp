package com.outlook.alessandroardu.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.outlook.alessandroardu.shoestore.R
import com.outlook.alessandroardu.shoestore.databinding.LoginScreenBinding

class LoginFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: LoginScreenBinding =
            DataBindingUtil.inflate(inflater, R.layout.login_screen, container, false)

        binding.loginRegisterButton.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        binding.loginSigninButton.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        setHasOptionsMenu(false)


        return binding.root
    }

}