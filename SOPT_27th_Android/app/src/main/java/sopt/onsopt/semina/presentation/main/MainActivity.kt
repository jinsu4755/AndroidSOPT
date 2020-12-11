package sopt.onsopt.semina.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import sopt.onsopt.semina.R
import sopt.onsopt.semina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.lifecycleOwner = this@MainActivity
        navigationSetting(binding)
    }

    private fun navigationSetting(binding: ActivityMainBinding) {
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment_main)
        NavigationUI.setupWithNavController(
            binding.bottomNavigationMain,
            navController
        )
    }
}