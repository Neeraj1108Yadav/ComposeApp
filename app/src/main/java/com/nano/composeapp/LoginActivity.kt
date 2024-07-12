package com.nano.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nano.composeapp.ui.theme.ComposeAppTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAppTheme {
                HelloContent()
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> }
            }
        }
    }

    @Composable
    private fun HelloContentOne(){
        Column(modifier = Modifier.padding(16.dp)) {
            var name by remember { mutableStateOf("") }
            if(name.isNotEmpty()){
                Text(
                    text = "Hello! $name",
                    modifier = Modifier.padding(top = 10.dp, bottom = 8.dp)
                        .width(IntrinsicSize.Max),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            OutlinedTextField(
                value = name,
                modifier = Modifier.width(IntrinsicSize.Max),
                onValueChange = {name = it},
                label = {Text("First Name")}
            )
        }
    }

    @Composable
    private fun HelloTwoContentScreen(){
        var lastName by remember { mutableStateOf("") }
        HelloContentTwo(name = lastName, onValueChange = {lastName = it})
    }

    @Composable
    private fun HelloContentTwo(name:String,onValueChange:(String)->Unit){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Last Name",
                modifier = Modifier.padding(top = 10.dp,bottom = 8.dp),
                style = MaterialTheme.typography.bodyLarge
            )

            OutlinedTextField(
                value = name,
                modifier = Modifier.width(IntrinsicSize.Max),
                onValueChange = onValueChange,
                label = { Text(text = "Last Name")}
            )
        }
    }


    @Composable
    private fun HelloContent(){
        Column(modifier = Modifier.padding(16.dp)) {
            HelloContentOne()
            HelloTwoContentScreen()
        }
    }


    @Preview(
        showBackground = true,
        showSystemUi = true
    )
    @Composable
    fun HelloContentPreview(){
        HelloContent()
    }
}