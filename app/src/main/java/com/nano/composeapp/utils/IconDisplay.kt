package com.nano.composeapp.utils

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.nano.composeapp.sealed.IconSource

/**
 * Created By Neeraj Yadav on 11/09/24
 */
@Composable
fun IconDisplay(
    iconSource:IconSource,
    contentDescription:String,
    modifier: Modifier
){
    when(iconSource){
        is IconSource.BitmapIcon ->{
            Icon(bitmap = iconSource.imageBitmap,
                contentDescription = contentDescription,
                modifier = modifier)
        }
        is IconSource.VectorIcon ->{
            Icon(imageVector = iconSource.imageVector,
                contentDescription = contentDescription,
                modifier = modifier)
        }
        is IconSource.PainterIcon ->{
            Icon(painter = iconSource.painter,
                contentDescription = contentDescription,
                modifier = modifier)
        }
    }
}