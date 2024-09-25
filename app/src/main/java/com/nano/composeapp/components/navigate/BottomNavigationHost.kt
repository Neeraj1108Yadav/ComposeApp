package com.nano.composeapp.components.navigate

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nano.composeapp.components.bottomnav.CartScreen
import com.nano.composeapp.components.bottomnav.HomeScreen
import com.nano.composeapp.components.bottomnav.MenuScreen
import com.nano.composeapp.components.bottomnav.ProfileScreen
import com.nano.composeapp.sealed.BottomNavigationScreens

/**
 * Created By Neeraj Yadav on 21/09/24
 */

@Composable
fun BottomNavigationHost(
    navController: NavController,
    modifier: Modifier
){
    NavHost(
        modifier = modifier,
        navController = navController as NavHostController,
        startDestination = BottomNavigationScreens.Home.route
    ) {
        composable(route = BottomNavigationScreens.Home.route){
            HomeScreen()
        }
        composable(route = BottomNavigationScreens.Menu.route){
            MenuScreen()
        }
        composable(route = BottomNavigationScreens.Cart.route){
            CartScreen()
        }
        composable(route = BottomNavigationScreens.Profile.route){
            ProfileScreen()
        }
    }
}