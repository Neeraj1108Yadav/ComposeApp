package com.nano.composeapp

sealed class Screen(
    val route:String
) {
    object Login : Screen(route = "login")

    object Profile: Screen(route = "Profile"){
        fun createRoute() = "Profile"
    }
}