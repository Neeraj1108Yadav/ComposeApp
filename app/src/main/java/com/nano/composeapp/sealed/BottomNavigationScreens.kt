package com.nano.composeapp.sealed

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.nano.composeapp.R

/**
 * Created By Neeraj Yadav on 20/09/24
 */
sealed class BottomNavigationScreens(
    val route:String,
    @StringRes val resourceId:Int,
    val icon: ImageVector
) {

    object Home:BottomNavigationScreens("Home", R.string.home,Icons.Filled.Home)
    object Menu:BottomNavigationScreens("Menu",R.string.menu,Icons.Filled.Menu)
    object Cart:BottomNavigationScreens("Cart",R.string.cart,Icons.Filled.ShoppingCart)
    object Profile:BottomNavigationScreens("Profile",R.string.profile,Icons.Filled.Person)
}