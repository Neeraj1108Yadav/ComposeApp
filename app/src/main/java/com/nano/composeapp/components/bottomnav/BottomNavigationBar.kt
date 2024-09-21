package com.nano.composeapp.components.bottomnav


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nano.composeapp.R
import com.nano.composeapp.components.navigate.BottomNavigationHost
import com.nano.composeapp.sealed.BottomNavigationScreens

/**
 * Created By Neeraj Yadav on 20/09/24
 */

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<BottomNavigationScreens>
) {
    var topBarTitle by remember { mutableStateOf("Home") }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            FoodAppBottomNav(navController, items,currentRoute)
        },
        topBar = {
            currentRoute?.let {
                topBarTitle = when(it){
                    "Home" -> {"Home"}
                    "Menu" -> {"Menu"}
                    "Cart" -> {"Cart"}
                    "Profile" -> {"Profile"}
                    else -> {"Home"}
                }
                CentreTopAppBar(title = topBarTitle)
            }

        }
    ) { innerPadding ->
        BottomNavigationHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun FoodAppBottomNav(
    navController: NavController,
    items:List<BottomNavigationScreens>,
    currentRoute:String?
){
    NavigationBar {

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CentreTopAppBar(title:String){
    CenterAlignedTopAppBar(
        title = {
            Text(text = title, style = MaterialTheme.typography.titleLarge )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White,
            titleContentColor = colorResource(id = R.color.text_color),
            actionIconContentColor = Color.Black
        ),
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Notifications, contentDescription = null)
            }
        }
    )
}