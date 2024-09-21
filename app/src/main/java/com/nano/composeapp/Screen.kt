package com.nano.composeapp

sealed class Screen(
    val route:String
) {
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

    object LoginScreen : Screen(route = "login_one"){
        fun createRoute() = "login_one"
    }

    object LazyColumn : Screen(route = "columnList"){
        fun createRoute() = "columnList"
    }

    object BottomNavigationBar : Screen(route = "bottomBar"){
        fun createRoute() = "bottomBar"
    }

}