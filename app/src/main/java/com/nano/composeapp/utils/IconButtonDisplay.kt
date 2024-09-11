package com.nano.composeapp.utils

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nano.composeapp.sealed.IconButtonSource

/**
 * Created By Neeraj Yadav on 11/09/24
 */
@Composable
fun IconButtonDisplay(iconButtonSource: IconButtonSource,
                      contentDescription:String,
                      modifier: Modifier,
                      onIconButtonClick: () -> Unit) {
    when(iconButtonSource){
        is IconButtonSource.VectorIcon->{
            IconButton(onClick = onIconButtonClick) {
                Icon(imageVector = iconButtonSource.imageVector,
                    contentDescription = contentDescription,
                    modifier = modifier)
            }
        }
        is IconButtonSource.BitmapIcon->{
            IconButton(onClick = onIconButtonClick) {
                Icon(bitmap = iconButtonSource.imageBitmap,
                    contentDescription = contentDescription,
                    modifier = modifier)
            }
        }
        is IconButtonSource.PainterIcon->{
            IconButton(onClick = onIconButtonClick) {
                Icon(painter = iconButtonSource.painter,
                    contentDescription = contentDescription,
                    modifier = modifier)
            }
        }
    }
}