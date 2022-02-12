package com.outlook.alessandroardu.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.outlook.alessandroardu.shoestore.databinding.ActivityMainBinding
import com.outlook.alessandroardu.shoestore.screens.shoe_list.ShoeListModel
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var viewModel: MainActivityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainActivityModel()
        binding.mainActivityModel = viewModel
        binding.setLifecycleOwner(this)

        //INOTE In MainActivity, setup the nav controller
        // with the toolbar and an AppBarConfiguration
        setUpNavigation()
    }

    private fun setUpNavigation() {
        //INOTE taken from
        // https://developer.android.com/guide/navigation/navigation-ui
        val main_layout = binding.toolbarLayout
        val toolbar = binding.toolbar
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)

    }


}