package com.nano.composeapp.components.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nano.composeapp.R

/**
 * Created By Neeraj Yadav on 02/09/24
 */

@Composable
fun FilledComposeButton(){

    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.teal_700),
            contentColor = colorResource(id = R.color.black)
        ),
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "Filled Button",
            fontSize = 20.sp
        )
    }
}