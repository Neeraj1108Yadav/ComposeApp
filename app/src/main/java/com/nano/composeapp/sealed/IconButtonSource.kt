package com.nano.composeapp.sealed

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created By Neeraj Yadav on 11/09/24
 */

sealed class IconButtonSource {
    data class VectorIcon(val imageVector:ImageVector) : IconButtonSource()
    data class BitmapIcon(val imageBitmap:ImageBitmap) : IconButtonSource()
    data class PainterIcon(val painter:Painter) : IconButtonSource()
}