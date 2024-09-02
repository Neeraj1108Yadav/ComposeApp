package com.nano.composeapp.components.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

/**
 * Created By Neeraj Yadav on 02/09/24
 */
//https://www.jetpackcompose.net/textfield-in-jetpack-compose
@Composable
fun SimpleInputText(){
    var textInput by remember { mutableStateOf(TextFieldValue("Text Field Without Bottom Indicator")) }
    TextField(
        value = textInput,
        onValueChange = {newText ->
            textInput = newText
        },
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        enabled = true,
        singleLine = true,
        isError = false,
        keyboardOptions = KeyboardOptions.Default,
        shape = MaterialTheme.shapes.small.copy(
            topStart = CornerSize(30f),
            topEnd = CornerSize(30f),
            bottomStart = CornerSize(30f),
            bottomEnd = CornerSize(30f)
        ),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun SimpleInputWithIndicator(){
    var textInput by remember { mutableStateOf(TextFieldValue("Text Field With Bottom Indicator")) }
    TextField(
        value = textInput,
        onValueChange = {newText ->
            textInput = newText
        },
        modifier = Modifier.padding(10.dp)
            .fillMaxWidth(),
        enabled = true,
        singleLine = true,
        isError = false,
        keyboardOptions = KeyboardOptions.Default,
        shape = MaterialTheme.shapes.small.copy(
            topStart = CornerSize(30f),
            topEnd = CornerSize(30f),
            bottomStart = ZeroCornerSize,
            bottomEnd = ZeroCornerSize
        ),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Gray
        )
    )
}