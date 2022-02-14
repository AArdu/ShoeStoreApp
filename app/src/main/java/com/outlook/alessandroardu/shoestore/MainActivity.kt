package com.outlook.alessandroardu.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.outlook.alessandroardu.shoestore.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //INOTE In MainActivity, setup the nav controller
        // with the toolbar and an AppBarConfiguration
        setUpNavigation()

    }

    private fun setUpNavigation() {
        //INOTE taken from
        // https://developer.android.com/guide/navigation/navigation-ui
        val toolbar = binding.toolbar

        // INOTE thanks to Diraj
        //  https://knowledge.udacity.com/questions/799263
        setSupportActionBar(toolbar)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController

        // INOTE for some reason the set indicates where the Up button IS NOT SHOWN
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.loginFragment,
            R.id.shoeListFragment,
        ))
        toolbar.setupWithNavController(navController, appBarConfiguration)

    }

}
