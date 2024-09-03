package com.nano.composeapp.components.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created By Neeraj Yadav on 02/09/24
 */
@Composable
fun OutlineComposeButton() {
    OutlinedButton(
        onClick = { },
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "Outlined Button",
            fontSize = 18.sp
        )
    }
}