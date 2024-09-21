package com.nano.composeapp.components.bottomnav


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nano.composeapp.components.navigate.BottomNavigationHost
import com.nano.composeapp.sealed.BottomNavigationScreens

/**
 * Created By Neeraj Yadav on 20/09/24
 */

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items:List<BottomNavigationScreens>
){
        Scaffold(
            bottomBar = {
                FoodAppBottomNav(navController,items)
            }
        ) {innerPadding ->
            BottomNavigationHost(navController = navController)
        }
}

@Composable
fun FoodAppBottomNav(
    navController: NavController,
    items:List<BottomNavigationScreens>
){
    NavigationBar {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.map{screens->
            NavigationBarItem(
                icon = {
                    BottomBarIcon(icon = screens.icon)
                },
                label = {
                    BottomBarLabel(label = screens.route)
                },
                alwaysShowLabel = true,
                selected = currentRoute == screens.route,
                onClick = {
                    navController.navigate(screens.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun BottomBarIcon(icon:ImageVector){
    Icon(
        imageVector = icon,
        contentDescription = null
    )
}

@Composable
fun BottomBarLabel(label:String){
    Text(text = label)
}