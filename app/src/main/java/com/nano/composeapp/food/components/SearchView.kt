package com.nano.composeapp.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nano.composeapp.R
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 22/09/24
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView() {
    var searchText by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchText,
        onValueChange = { newText ->
            searchText = newText
        },
        placeholder = {
            Text(
                text = "Search in Foodou",
                color = colorResource(id = R.color.placeholder_color),
                fontFamily = notoSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = colorResource(id = R.color.text_color),
            unfocusedBorderColor = colorResource(id = R.color.placeholder_color),
            focusedBorderColor = colorResource(id = R.color.placeholder_color),
            focusedContainerColor = colorResource(id = R.color.input_box_color),
            unfocusedContainerColor = colorResource(id = R.color.input_box_color),
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = null,
                tint = colorResource(id = R.color.placeholder_color)
            )
        },
        shape = RoundedCornerShape(10.dp)
    )
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun SearchViewPreview(){
    SearchView()
}
