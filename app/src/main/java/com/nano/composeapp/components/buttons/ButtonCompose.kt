package com.nano.composeapp.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            
            Text(text = stringResource(id = R.string.button_shapes),
                modifier = Modifier.padding(10.dp),
                fontSize = 18.sp)
            
            ExposedDropdownMenuBoxScope()
            
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = stringResource(id = R.string.button_types),
                modifier = Modifier.padding(10.dp),
                fontSize = 18.sp)

            FilledComposeButton()

            ComposeFilledTonalButton()

            OutlineComposeButton()

            ElevatedComposableButton()

            ButtonComposableText()
        }
    }
}

//https://medium.com/@jayeshseth/constraint-layout-jetpack-compose-a3545f3dee00
@Composable
fun ExposedDropdownMenuBoxScope(){
    val buttonShapeOptions = arrayOf(
        ButtonShapeEnum.ROUND_CORNER.shape,
        ButtonShapeEnum.RECTANGLE_CORNER.shape,
        ButtonShapeEnum.CUT_CORNER.shape,
        ButtonShapeEnum.ABSOLUTE_CORNER.shape,
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedShape by remember { mutableStateOf(buttonShapeOptions[0]) }
    var shape by remember { mutableStateOf(ButtonShapeEnum.ROUND_CORNER) }

    Row(modifier = Modifier.padding(10.dp)){
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Gray)
        ){
            Text(
                text = selectedShape,
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .clickable(onClick = { expanded = true })
                    .padding(10.dp)
            )

            IconButton(
                onClick = { expanded = true },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            ) {
                val icon = if(expanded){ Icons.Filled.KeyboardArrowUp }else{ Icons.Filled.KeyboardArrowDown }
                Icon(
                    imageVector = icon,
                    contentDescription = "More",
                    tint = Color.White
                )
            }

            DropdownMenu(
                modifier = Modifier.background(Color.Red),
                expanded = expanded, // When expand set to true, drop down will expand
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

                shape = ButtonShapeEnum.values().find { it.shape == selectedShape } ?: ButtonShapeEnum.ROUND_CORNER
            }
        }

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
            .weight(1f)){
            ButtonShapeChange(shape,selectedShape)
        }
    }
}

@Composable
fun ButtonShapeChange(shape: ButtonShapeEnum, shapeType:String){
    val buttonShape = when(shape){
        ButtonShapeEnum.RECTANGLE_CORNER->{ RectangleShape}
        ButtonShapeEnum.CUT_CORNER->{ CutCornerShape(10.dp) }
        ButtonShapeEnum.ABSOLUTE_CORNER->{ AbsoluteRoundedCornerShape(20.dp) }
        else->{RoundedCornerShape(10.dp)}
    }

    Button(
        onClick = { },
        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.teal_700),
            contentColor = colorResource(id = R.color.black)
        ),
        shape = buttonShape
    ) {
        Text(text = shapeType)
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonComposePreview(){
    ButtonCompose()
}