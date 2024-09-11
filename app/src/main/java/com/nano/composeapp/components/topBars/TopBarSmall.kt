package com.nano.composeapp.components.topBars

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                Text(text = "Medium Top Bar", style = MaterialTheme.typography.bodyLarge)
            }

            Button(
                onClick = {navHostController.navigate(Screen.LargeTopBar.createRoute())},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RectangleShape)
            {
                Text(text = "Large Top Bar",style = MaterialTheme.typography.bodyLarge)
            }

            Button(
                onClick = {navHostController.navigate(Screen.CentralTopBar.createRoute())},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RectangleShape)
            {
                Text(text = "Central Top Bar",style = MaterialTheme.typography.bodyLarge)
            }
            NormalSlider()
            NormalStepsSlider()
            RangeStepsSlider()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBar(navHostController: NavHostController){
    TopAppBar(
        title = { Text(text = "Small App Bar Title",style = MaterialTheme.typography.titleLarge) },
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

@Composable
fun NormalSlider(){
    var slideValue by remember { mutableFloatStateOf(0f) }

    Column {
        Text(text = "Normal Slider",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(10.dp)
        )

        Slider(
            modifier = Modifier.padding(start = 20.dp,end=20.dp).height(20.dp),
            value = slideValue,
            onValueChange = {slideValue = it},
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Blue,
                inactiveTrackColor = Color.LightGray
            )
        )

    }
}

@Composable
fun NormalStepsSlider(){
    var slideValue by remember { mutableFloatStateOf(0f) }

    Column {
        Text(text = "Steps Slider",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(10.dp)
        )

        Slider(
            modifier = Modifier.padding(start = 20.dp,end=20.dp).height(50.dp),
            value = slideValue,
            onValueChange = {slideValue = it},
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Red,
                inactiveTrackColor = Color.LightGray,
                inactiveTickColor = Color.White,
                activeTickColor = Color.Yellow
            ),
            steps = 4,
            valueRange = 0f..100f,

        )

    }
}

@Composable
fun RangeStepsSlider(){
    var slideValue by remember { mutableStateOf(0f..100f) }

    Column {
        Text(text = "Range Steps Slider",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(10.dp)
        )

        RangeSlider(
            modifier = Modifier.padding(start = 20.dp,end=20.dp).height(50.dp),
            value = slideValue,
            onValueChange = {slideValue = it},
            colors = SliderDefaults.colors(
                thumbColor = Color.Magenta,
                activeTrackColor = Color.Magenta,
                inactiveTrackColor = Color.LightGray,
                inactiveTickColor = Color.White,
                activeTickColor = Color.Yellow
            ),
            steps = 5,
            valueRange = 0f..100f,
            onValueChangeFinished = {

            }
        )

    }
}