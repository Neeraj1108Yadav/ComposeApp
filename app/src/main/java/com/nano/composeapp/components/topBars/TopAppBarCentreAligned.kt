package com.nano.composeapp.components.topBars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

/**
 * Created By Neeraj Yadav on 08/09/24
 */

@Composable
fun TopAppBarCentreAligned(onBackPress:() -> Unit){
    Scaffold (
        topBar = {
            CenterTopAppBar(onBackPress)
        },
        floatingActionButton = {
            ExtendedFloatingButton()
        }
    ){innerPadding ->

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopAppBar(onBackPress:() -> Unit){
   CenterAlignedTopAppBar(
       title = { Text(text = "Title Centred App Bar") },
       colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
           containerColor = MaterialTheme.colorScheme.secondaryContainer,
           titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer
       ),
       navigationIcon = {
           IconButton(onClick = onBackPress) {
               Icon(imageVector = Icons.Sharp.ArrowBack, contentDescription = "Back")
           }
       },
       actions = {
           IconButton(onClick = { /*TODO*/ }) {
               Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = "Account" )
           }
       }
   )
}

@Composable
fun ExtendedFloatingButton(){
   ExtendedFloatingActionButton(
       text = { Text(text = "Extended Text") },
       icon = { Icon(imageVector = Icons.Rounded.AddCircle, contentDescription = "Add") },
       onClick = { /*TODO*/ }
   )
}