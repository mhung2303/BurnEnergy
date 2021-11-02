package com.carter.burnenergy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.carter.burnenergy.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var  navController: NavController
    private lateinit var bottomNav : BottomNavigationView
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        bottomNav = binding.bottomView
        bottomNav.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.navigation_home -> navController.navigate(R.id.homeFragment)
                R.id.view_pager_fragment -> navController.navigate(R.id.viewPagerFragment)
                R.id.navigation_favourite -> navController.navigate(R.id.favouriteFragment)
            }
            true
        }

    }

}