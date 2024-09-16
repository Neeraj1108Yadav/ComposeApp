package com.nano.composeapp

sealed class Screen(
    val route:String
) {
    object Login : Screen(route = "login")

    object Profile: Screen(route = "Profile"){
        fun createRoute() = "Profile"
    }

    object MainScreen : Screen(route = "main"){
        fun createRoute() = "main"
    }

    object ButtonsScreen : Screen(route = "buttons"){
        fun createRoute() = "buttons"
    }

    object CardScreen : Screen(route = "cards"){
        fun createRoute() = "cards"
    }

    object InputScreen : Screen(route = "input"){
        fun createRoute() = "input"
    }

    object TopBarsScreen : Screen(route = "topBar"){
        fun createRoute() = "topBar"
    }

    object MediumTopBar : Screen(route = "mediumTopBar"){
        fun createRoute() = "mediumTopBar"
    }

    object CentralTopBar : Screen(route = "centralTopBar"){
        fun createRoute() = "centralTopBar"
    }

    object LargeTopBar : Screen(route = "largeTopBar"){
        fun createRoute() = "largeTopBar"
    }

    object LazyColumn : Screen(route = "columnList"){
        fun createRoute() = "columnList"
    }
}