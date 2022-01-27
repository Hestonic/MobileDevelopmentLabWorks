package com.example.homework6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.homework6.databinding.ActivityMainBinding

// Сделать:
// 0. Разобраться как сделать setBackground
// 1. При наличии связей в ParentFragment существующая связь закрашивается
// 2. При нажатии на существующую связь можно только удалить
// 3.
// 4. При наличии связей во

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        MAIN = this

        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return  navController.navigateUp() || super.onSupportNavigateUp()
    }
}