package com.example.epamcoronavirusmap.ui.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.epamcoronavirusmap.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = bottom_nav as BottomNavigationView
        val navHostFragment = nav_host_fragment as NavHostFragment
        bottomNavigationView.setupWithNavController(navHostFragment.navController)
    }
}
