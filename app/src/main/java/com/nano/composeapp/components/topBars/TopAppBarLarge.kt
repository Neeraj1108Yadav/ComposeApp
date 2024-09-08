package com.nano.composeapp.components.topBars

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

/**
 * Created By Neeraj Yadav on 08/09/24
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarLarge(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBarLargeExample(scrollBehavior)
        },
        floatingActionButton = {
            LargeFloatingButton()
        }
    ) {innerPadding->
        VerticalLargeScrollList(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarLargeExample(scrollBehavior: TopAppBarScrollBehavior){
    LargeTopAppBar(
        title = { Text(text = "Large Top App Bar") },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "Noti")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Person, contentDescription = "User")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "Cart")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.ExitToApp, contentDescription = "Exit")
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
fun VerticalLargeScrollList(innerPadding: PaddingValues){
    LazyColumn(modifier = Modifier.padding(innerPadding)){
        item { Text(text = "First Item") }
        items(count = 100){ index ->
            Text(text = "Large Item Index $index")
        }
        item { Text(text = "Last Item") }
    }
}

@Composable
fun LargeFloatingButton(){
    LargeFloatingActionButton(
        onClick = { /*TODO*/ },
        shape = CircleShape) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add" )
    }
}

