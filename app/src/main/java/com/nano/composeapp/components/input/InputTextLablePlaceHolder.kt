package com.nano.composeapp.components.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

/**
 * Created By Neeraj Yadav on 02/09/24
 */

@Composable
fun TextInputLabelPlaceHolder(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {newText ->
            text = newText
        },
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        label = {Text(text = "Input Field Label")},
        placeholder = { Text(text = "Please enter your name")},
        enabled = true,
        singleLine = true,
        isError = false,
        shape = MaterialTheme.shapes.extraSmall
    )
}