package com.nano.composeapp.components.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created By Neraj Yadav on 02/09/24
 */
@Composable
fun ComposeFilledTonalButton(){
    FilledTonalButton(
        onClick = { },
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "Filled Tonal Button",
            fontSize = 18.sp
        )
    }
}