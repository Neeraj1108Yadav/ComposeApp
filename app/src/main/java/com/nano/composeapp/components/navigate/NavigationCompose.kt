package com.nano.composeapp.components.navigate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created By Neeraj Yadav on 09/09/24
 */

@Composable
fun NavigateToComponents(
    onNavigateToButton: () -> Unit,
    onNavigateToCard: () -> Unit,
    onNavigateToInput: ()-> Unit,
    onNavigateToTopBar: () -> Unit,
    onNavigateToLoginOne: () -> Unit,
    onNavigateToLazyColumn: () -> Unit,
    onNavigateToBottomBar: () -> Unit,
){

    Column(modifier = Modifier.padding(top = 60.dp)) {
        Button(
            onClick = onNavigateToButton,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Buttons", style = MaterialTheme.typography.bodyLarge)
        }

        Button(
            onClick = onNavigateToInput,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Input Field",style = MaterialTheme.typography.bodyLarge)
        }

        Button(
            onClick = onNavigateToCard,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Card-Chips-CheckBox",style = MaterialTheme.typography.bodyLarge)
        }

        Button(
            onClick = onNavigateToTopBar,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Top App Bar",style = MaterialTheme.typography.bodyLarge)
        }

        Button(
            onClick = onNavigateToLoginOne,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Login Screen 1",style = MaterialTheme.typography.bodyLarge)
        }

        Button(
            onClick = onNavigateToLazyColumn,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Lazy Column",style = MaterialTheme.typography.bodyLarge)
        }

        Button(
            onClick = onNavigateToBottomBar,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Bottom Navigation",style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigateToComposePreview(){
    NavigateToComponents({},{},{},{},{},{},{})
}