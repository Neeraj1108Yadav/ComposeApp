package com.nano.composeapp.components.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
fun OutlineInputField(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        onValueChange = {newText->
            text = newText
        },
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        label = { Text(text = "Gender")}
    )
}

@Composable
fun OutlineInputFieldILeadingIcon(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        onValueChange = {newText->
            text = newText
        },
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        label = { Text(text = "Email")},
        placeholder = { Text(text = "Enter your email")},
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon")}
    )
}

@Composable
fun OutlineInputFieldITrailingIcon(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        onValueChange = {newText->
            text = newText
        },
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        label = { Text(text = "Info")},
        placeholder = { Text(text = "Add the info")},
        trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = "addIcon")}
    )
}