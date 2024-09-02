package com.nano.composeapp.components.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

/**
 * Created By Neeraj Yadav on 02/09/24
 */
@Composable
fun InputTextShapeExtraSmall(){
    var text by remember { mutableStateOf(TextFieldValue("Shape Extra Small")) }
    TextField(
        value = text,
        onValueChange = {newText ->
            text = newText
        },
        shape = MaterialTheme.shapes.extraSmall,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun InputTextShapeSmall(){
    var text by remember { mutableStateOf(TextFieldValue("Shape Small")) }
    TextField(
        value = text,
        onValueChange = {newText ->
            text = newText
        },
        shape = MaterialTheme.shapes.small,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun InputTextShapeMedium(){
    var text by remember { mutableStateOf(TextFieldValue("Shape Medium")) }
    TextField(
        value = text,
        onValueChange = {newText ->
            text = newText
        },
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),

    )
}

@Composable
fun InputTextShapeLarge(){
    var text by remember { mutableStateOf(TextFieldValue("Shape Large")) }
    TextField(
        value = text,
        onValueChange = {newText ->
            text = newText
        },
        shape = MaterialTheme.shapes.large,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun InputTextShapeExtraLarge(){
    var text by remember { mutableStateOf(TextFieldValue("Shape Extra Large")) }
    TextField(
        value = text,
        onValueChange = {newText ->
            text = newText
        },
        shape = MaterialTheme.shapes.extraLarge,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}