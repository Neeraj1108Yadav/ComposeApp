package com.nano.composeapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 10/09/24
 */

@Composable
fun TextTitle(title:String,modifier: Modifier){
    Text(
        modifier = modifier,
        text = title,
        fontSize = 28.sp,
        color = Color.White,
        fontFamily = notoSansFontFamily,
        fontWeight = FontWeight.Bold)
}

@Composable
fun TextLabel(
    text:String,
    color: Color,
    fontWeight: FontWeight,
    fontSize:TextUnit
){
    Text(
        text = text,
        fontSize = fontSize,
        color = color,
        fontFamily = notoSansFontFamily,
        fontWeight = fontWeight
    )
}

@Composable
fun ModifiedTextLabel(
    text:String,
    modifier: Modifier,
    color: Color,
    fontWeight: FontWeight,
    fontSize:TextUnit
){
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = color,
        fontFamily = notoSansFontFamily,
        fontWeight = fontWeight
    )
}