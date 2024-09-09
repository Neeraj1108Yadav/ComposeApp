package com.nano.composeapp.components.navigate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
    onNavigateToTopBar: () -> Unit
){

    Column(modifier = Modifier.padding(top = 60.dp)) {
        Button(
            onClick = onNavigateToButton,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Buttons")
        }

        Button(
            onClick = onNavigateToInput,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Input Field")
        }

        Button(
            onClick = onNavigateToCard,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Card-Chips-CheckBox")
        }

        Button(
            onClick = onNavigateToTopBar,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RectangleShape)
        {
            Text(text = "Top App Bar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigateToComposePreview(){
    NavigateToComponents({},{},{},{})
}