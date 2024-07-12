package com.nano.composeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowerScreenLogin(){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Login Screen")
                }
            )
        }
    ) { innerPadding ->
        val padding = 10.dp
        Column(modifier = Modifier.padding(innerPadding)) {
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            Text(
                text = "Username",
                modifier = Modifier.padding(padding),
                color = colorResource(id = R.color.black)
            )

            OutlinedTextField(
                value = username,
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth(),
                onValueChange = {username = it},
                label = { Text(text = "Username")},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = colorResource(id = R.color.focused_text_field)
                )
            )

            Text(
                text = "Password",
                modifier = Modifier.padding(padding),
                color = colorResource(id = R.color.black)
            )

            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth(),
                label = { Text(text = "Password")},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = colorResource(id = R.color.focused_text_field)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            ElevatedButton(
                onClick = { },
                modifier = Modifier.align(Alignment.CenterHorizontally).height(60.dp)
            ) {
                Text(text = "Login")
            }
        }
    }
}