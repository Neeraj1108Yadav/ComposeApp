package com.nano.composeapp.components.topBars

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created By Neeraj Yadav on 08/09/24
 */

@Composable
fun TopAppBarCentreAligned(onBackPress:() -> Unit){
    Scaffold (
        topBar = {
            CenterTopAppBar(onBackPress)
        },
        floatingActionButton = {
            ExtendedFloatingButton()
        }
    ){innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "Determinate Progress",
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.titleLarge
            )
            ProgressIndicatorLinear()
            Text(
                text = "Indeterminate Progress",
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.titleLarge
            )
            IndeterminateProgress()
            Text(
                text = "Circular Determinate Progress",
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.titleLarge
            )
            ProgressCircular()
            Text(
                text = "Circular Indeterminate Progress",
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.titleLarge
            )
            IndeterminateCircular()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopAppBar(onBackPress:() -> Unit){
   CenterAlignedTopAppBar(
       title = { Text(text = "Title Centred App Bar", style = MaterialTheme.typography.titleLarge) },
       colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
           containerColor = MaterialTheme.colorScheme.secondaryContainer,
           titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer
       ),
       navigationIcon = {
           IconButton(onClick = onBackPress) {
               Icon(imageVector = Icons.Sharp.ArrowBack, contentDescription = "Back")
           }
       },
       actions = {
           IconButton(onClick = { /*TODO*/ }) {
               Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = "Account" )
           }
       }
   )
}

@Composable
fun ExtendedFloatingButton(){
   ExtendedFloatingActionButton(
       text = { Text(text = "Extended Text") },
       icon = { Icon(imageVector = Icons.Rounded.AddCircle, contentDescription = "Add") },
       onClick = { /*TODO*/ }
   )
}

@Composable
fun ProgressIndicatorLinear(){
    var loading by remember { mutableStateOf(false) }
    var progress by remember { mutableFloatStateOf(0f) }
    val scope = rememberCoroutineScope()
    Column {
        Button(
            modifier = Modifier.padding(15.dp),
            onClick = {
                if (!loading) {
                    loading = true
                    scope.launch {
                        startProgress(updateProgress = {currentProgress->
                            progress = currentProgress
                        })
                        progress = 0f
                        loading = false
                    }
                }
            },
            shape = CutCornerShape(10.dp),
            enabled = !loading
        ) {
            if(loading){
                Text(text = "Loading...")
            }else{
                Text(text = "Start Loading")
            }
        }

       LinearProgressIndicator(
           progress = progress,
           modifier = Modifier
               .padding(15.dp)
               .fillMaxWidth()
       )
    }
}

suspend fun startProgress(updateProgress:(Float) -> Unit){
    for(count in 0..100){
        updateProgress(count.toFloat()/100)
        delay(1000)
    }
}

@Composable
fun IndeterminateProgress(){
    LinearProgressIndicator(
        modifier = Modifier
            .padding(15.dp)
            .height(15.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        color = MaterialTheme.colorScheme.onTertiaryContainer,
        strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
        trackColor = MaterialTheme.colorScheme.tertiary
    )
}

@Composable
fun ProgressCircular(){
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column {
        Button(
            modifier = Modifier.padding(start = 10.dp),
            onClick = {
                if(!loading){
                    loading = true
                    scope.launch {
                        circularProgress { progress ->
                            currentProgress = progress
                        }
                        currentProgress = 0f
                        loading = false
                    }
                }
            },
            enabled = !loading
        ) {
            if(loading){
                Text(text = "In Progress..", style = MaterialTheme.typography.labelLarge)
            }else{
                Text(text = "Start Circular Progress", style = MaterialTheme.typography.labelLarge)
            }
        }

        CircularProgressIndicator(
            progress = currentProgress,
            modifier = Modifier.padding(15.dp).width(60.dp),
            trackColor = Color.LightGray,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            strokeWidth = 10.dp
        )
    }
}

suspend fun circularProgress(progress:(Float) -> Unit){
    for(count in 0..100){
        progress(count.toFloat()/100)
        delay(1000)
    }
}

@Composable
fun IndeterminateCircular(){
    CircularProgressIndicator(
        modifier = Modifier.padding(15.dp).width(60.dp),
        trackColor = Color.LightGray,
        color = MaterialTheme.colorScheme.onSecondaryContainer,
        strokeWidth = 10.dp
    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarCentreAlignedPreview(){
    TopAppBarCentreAligned({})
}