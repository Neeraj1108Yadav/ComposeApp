package com.nano.composeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.nano.composeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonCompose(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "Buttons")}
            )
        }
    ) {innerPadding->
        Column(modifier = Modifier.padding(innerPadding)) {
            
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_700),
                    contentColor = colorResource(id = R.color.black)
                ),
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Default Shape Button")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.padding(10.dp)){
                ExposedDropdownMenuBoxScope()

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.teal_700),
                        contentColor = colorResource(id = R.color.black)
                    )
                ) {
                    Text(text = "Default Shape Button")
                }
            }

        }
    }
}

@Composable
fun ExposedDropdownMenuBoxScope(){
    val buttonShapeOptions = arrayOf("Default Shape","Elevated Shape","FilledTonal Shape","Outlined Shape","Text Shape")

    var expanded by remember { mutableStateOf(false) }
    var selectedShape by remember { mutableStateOf(buttonShapeOptions[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.Start)
    ){

        Text(
            text = selectedShape,
            modifier = Modifier.fillMaxWidth()
                .clickable(onClick = {expanded = true}).background(Color.Gray)
        )

        IconButton(
            onClick = { }
        ) {
            val icon = if(expanded){
                Icons.Filled.KeyboardArrowUp
            }else{
                Icons.Filled.KeyboardArrowDown
            }

            Icon(
                imageVector = icon,
                contentDescription = "More"
            )
        }


        DropdownMenu(
            modifier = Modifier.fillMaxWidth().background(Color.Red),
            expanded = expanded,
            onDismissRequest = { expanded = false}
        ) {

            buttonShapeOptions.forEachIndexed { index, label ->
                DropdownMenuItem(
                    text = { Text(text = label) },
                    onClick = {
                        selectedShape = label
                        expanded = false
                    }
                )
            }
        }
    }

}