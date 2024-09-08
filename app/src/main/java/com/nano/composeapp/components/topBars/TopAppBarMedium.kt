package com.nano.composeapp.components.topBars

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.twotone.Call
import androidx.compose.material.icons.twotone.Menu
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
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
fun AppBarMedium(){
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumAppBar(scrollBehavior)
        },
        floatingActionButton = {
            FloatingButton()
        }
    ){innerPadding->
        VerticalScrollList(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumAppBar(scrollBehavior: TopAppBarScrollBehavior){
    MediumTopAppBar(
        title = { Text(text = "Medium App Bar Title") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.TwoTone.Menu, contentDescription = "Menu" )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.TwoTone.Search, contentDescription = "Search" )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.TwoTone.Call, contentDescription = "Call" )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
fun VerticalScrollList(innerPadding:PaddingValues){
    LazyColumn(modifier = Modifier.padding(innerPadding)){
        item { Text(text = "First Item") }
        items(count = 100){ index ->
            Text(text = "Middle Item Index $index")
        }
        item { Text(text = "Last Item") }
    }
}

@Composable
fun FloatingButton(){
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer) {
        Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "Arrow")
    }
}