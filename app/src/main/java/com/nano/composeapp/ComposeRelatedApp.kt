package com.nano.composeapp

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
    NavHost(navController = navHostController, startDestination = Screen.Login.route){
        composable(route = Screen.Login.route){
            UserLoginScreen(
                onLoginClick = {
                    navHostController.navigate(Screen.Profile.createRoute())
                }
            )
        }

        composable(route = Screen.Profile.route){
            UserProfileScreen(
                onBackArrowClick = {navHostController.popBackStack()}
            )
        }
    }
}