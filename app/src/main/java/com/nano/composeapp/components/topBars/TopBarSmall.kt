package com.nano.composeapp.components.topBars

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nano.composeapp.Screen

/**
 * Created By Neeraj Yadav on 07/09/24
 */
@Composable
fun TopBarSmall(
    navHostController: NavHostController
){
    Scaffold (
        topBar = {
            SmallTopAppBar(navHostController)
        },
        floatingActionButton = {
            SmallFloatingButton()
        }
    ){innerPadding->
        Column(modifier = Modifier.padding(innerPadding)) {
            Button(
                onClick = {navHostController.navigate(Screen.MediumTopBar.createRoute())},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RectangleShape
            )
            {
                Text(text = "Medium Top Bar")
            }

            Button(
                onClick = {navHostController.navigate(Screen.LargeTopBar.createRoute())},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RectangleShape)
            {
                Text(text = "Large Top Bar")
            }

            Button(
                onClick = {navHostController.navigate(Screen.CentralTopBar.createRoute())},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RectangleShape)
            {
                Text(text = "Central Top Bar")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBar(navHostController: NavHostController){
    TopAppBar(
        title = { Text(text = "Small App Bar Title") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton(onClick = { navHostController.popBackStack()}) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back" )
            }
        }

    )
}

@Composable
fun SmallFloatingButton(){
    SmallFloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer) {
        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More")
    }
}