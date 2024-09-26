package com.nano.composeapp.food.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 25/09/24
 */

@Composable
fun SmallTextCompose(text:String,
                     color:Color,
                     modifier: Modifier){
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = 15.sp,
        fontFamily = notoSansFontFamily,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun MediumTextCompose(text:String,
                      color:Color,
                      modifier: Modifier){
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = 18.sp,
        fontFamily = notoSansFontFamily,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun SemiBoldTextCompose(text:String,
                        color:Color,
                        modifier: Modifier){
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = 20.sp,
        fontFamily = notoSansFontFamily,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun BoldTextCompose(text:String,
                    color:Color,
                    modifier: Modifier){
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = 20.sp,
        fontFamily = notoSansFontFamily,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ExtraBoldTextCompose(text:String,
                         color:Color,
                         modifier: Modifier){
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = 22.sp,
        fontFamily = notoSansFontFamily,
        fontWeight = FontWeight.W900
    )
}