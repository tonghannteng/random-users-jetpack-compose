package com.example.randomusers.navigation

/**
 * @author: tonghann.teng
 * @since: 8/1/23
 */
sealed class Destination(val route: String) {
    data object Home : Destination("home")
    data object Details : Destination("details")
}
