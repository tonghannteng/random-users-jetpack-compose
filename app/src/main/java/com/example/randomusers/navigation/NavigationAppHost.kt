package com.example.randomusers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.randomusers.screens.DetailsScreen
import com.example.randomusers.screens.HomeScreen
import com.example.randomusers.viewmodel.UserResultViewModel

/**
 * @author: tonghann.teng
 * @since: 8/1/23
 */
@Composable
fun NavigationAppHost(
    navController: NavHostController,
    viewModel: UserResultViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Home.route
    ) {
        composable(Destination.Home.route) {
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(Destination.Details.route) {
            DetailsScreen(
                viewModel = viewModel
            )
        }
    }
}
