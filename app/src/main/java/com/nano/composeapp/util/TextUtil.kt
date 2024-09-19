package com.nano.composeapp.util

import androidx.compose.ui.text.capitalize

/**
 * Created By Neeraj Yadav on 19/09/24
 */

fun setFirstLetterCapital(text:String):String{
    return text.replaceFirstChar { it.uppercase() }
}