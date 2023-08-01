package com.example.randomusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.randomusers.navigation.NavigationAppHost
import com.example.randomusers.viewmodel.UserResultViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author: tonghann.teng
 * @since: 7/25/23
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: UserResultViewModel by viewModels()
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            viewModel.getAllResults()
            NavigationAppHost(navController = navController, viewModel = viewModel)
        }
    }
}
