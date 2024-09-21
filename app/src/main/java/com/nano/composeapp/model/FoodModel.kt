package com.nano.composeapp.model

import androidx.compose.ui.graphics.ImageBitmap

/**
 * Created By Neeraj Yadav on 21/09/24
 */
data class FoodModel(
    val name:String,
    val subName:String,
    val category:String,
    val description:String,
    val price:String,
    val image:ImageBitmap,
    val rating:Int,
    val topOfWeek:Boolean = false,
    val featured:Boolean = false
)
