package com.nano.composeapp


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Profile Screen")
                }
            )
        }
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            Spacer(modifier = Modifier.height(16.dp))

            Row (modifier = Modifier.fillMaxWidth()){
                Box(modifier = Modifier.weight(1f)){HeightContent()}
                Box(modifier = Modifier.weight(1f)){WeightContent()}
            }
            
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()){
                Box(modifier = Modifier.weight(1f)){AgeContent()}
                Box(modifier = Modifier.weight(1f)){GenderContent()}
            }

            Spacer(modifier = Modifier.height(16.dp))

            ElevatedButton(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(60.dp)
            ) {
                Text(text = stringResource(id = R.string.save_profile))
            }
        }
    }
}

/*
    @HeightCompose() is testable compose
 */
@Composable
private fun HeightCompose(height:String,onValueChange: (String) -> Unit){
    Column {
        ProfileText(label = "Height", color = R.color.black)
        ProfileTextField(label = "Height",value = height,onValueChange = onValueChange)
    }
}

/*
    @WeightCompose() is testable compose
 */
@Composable
private fun WeightCompose(weight:String,onValueChange: (String) -> Unit){
    Column {
        ProfileText(label = "Weight", color = R.color.black)
        ProfileTextField(label = "Weight",value = weight,onValueChange = onValueChange)
    }
}

/*
    @AgeCompose() is testable compose
 */
@Composable
private fun AgeCompose(age:String,onValueChange: (String) -> Unit){
    Column {
        ProfileText(label = "Age", color = R.color.black)
        ProfileTextField(label = "Age",value = age,onValueChange = onValueChange)
    }
}

/*
    @GenderCompose() is testable compose
 */
@Composable
private fun GenderCompose(gender:String,onValueChange: (String) -> Unit){
    Column {
        ProfileText(label = "Gender", color = R.color.black)
        ProfileTextField(label = "Gender",value = gender,onValueChange = onValueChange)
    }
}

@Composable
private fun WeightContent(){
    var weight by remember { mutableStateOf("") }
    WeightCompose(weight = weight, onValueChange = {weight = it})
}

@Composable
private fun HeightContent(){
    var height by remember { mutableStateOf("") }
    HeightCompose(height = height, onValueChange = {height = it})
}

@Composable
private fun AgeContent(){
    var age by remember { mutableStateOf("") }
    AgeCompose(age = age, onValueChange = {age = it})
}

@Composable
private fun GenderContent(){
    var gender by remember { mutableStateOf("") }
    GenderCompose(gender = gender, onValueChange = {gender = it})
}

@Composable
fun ProfileText(label:String,color:Int){
    Text(
        text = label,
        modifier = Modifier.padding(start = 10.dp),
        color = colorResource(id = color)
    )
}

@Composable
fun ProfileTextField(label: String,value:String,onValueChange:(String) -> Unit){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
        label = {ProfileText(label = label, color = R.color.unfocused_text_field)}
    )
}
