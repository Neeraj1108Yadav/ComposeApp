package com.nano.composeapp

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nano.composeapp.components.buttons.ButtonCompose
import com.nano.composeapp.components.cards.CardComponent
import com.nano.composeapp.components.input.TextInputCompose
import com.nano.composeapp.components.list.LazyListColumn
import com.nano.composeapp.components.navigate.NavigateToComponents
import com.nano.composeapp.components.topBars.AppBarMedium
import com.nano.composeapp.components.topBars.TopAppBarCentreAligned
import com.nano.composeapp.components.topBars.TopAppBarLarge
import com.nano.composeapp.components.topBars.TopBarSmall
import com.nano.composeapp.screens.login.LoginScreen

@Composable
fun ComposeRelatedApp(){
    val navController = rememberNavController()
    ComposeAppNavHost(navHostController = navController)
}

@Composable
fun ComposeAppNavHost(
    navHostController: NavHostController
){
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navHostController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            NavigateToComponents(
                onNavigateToButton = {
                    navHostController.navigate(Screen.ButtonsScreen.createRoute())
                },
                onNavigateToCard = {
                    navHostController.navigate(Screen.CardScreen.createRoute())
                },
                onNavigateToInput = {
                    navHostController.navigate(Screen.InputScreen.createRoute())
                },
                onNavigateToTopBar = {
                    navHostController.navigate(Screen.TopBarsScreen.createRoute())
                },
                onNavigateToLoginOne = {
                    navHostController.navigate(Screen.LoginScreen.createRoute())
                },
                onNavigateToLazyColumn = {
                    navHostController.navigate(Screen.LazyColumn.createRoute())
                }
            )
        }
        composable(Screen.ButtonsScreen.route){
            ButtonCompose(
                onClickBack = {
                    navHostController.popBackStack()
                }
            )
        }
        composable(Screen.InputScreen.route){
            TextInputCompose(
                onClickBack = {
                    navHostController.popBackStack()
                }
            )
        }
        composable(Screen.CardScreen.route){
            CardComponent(
                onClickBack ={
                    navHostController.popBackStack()
                }
            )
        }
        composable(Screen.TopBarsScreen.route){
            TopBarSmall(navHostController)
        }
        composable(Screen.MediumTopBar.route){
            AppBarMedium(
                onBackPress = {
                    navHostController.popBackStack()
                }
            )

        }
        composable(Screen.CentralTopBar.route){
            TopAppBarCentreAligned(
                onBackPress = {
                    navHostController.popBackStack()
                }
            )
        }
        composable(Screen.LargeTopBar.route){
            TopAppBarLarge(
                onBackPress = {
                    navHostController.popBackStack()
                }
            )
        }
        composable(Screen.LoginScreen.route){
            LoginScreen()
        }

        composable(route = Screen.LazyColumn.route){
            LazyListColumn()
        }
    }
}