package com.nano.composeapp.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.nano.composeapp.R


/**
 * Created By Neeraj Yadav on 10/09/24
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransparentTopAppBar(){
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.login_signup_bg)
        )
    )
}