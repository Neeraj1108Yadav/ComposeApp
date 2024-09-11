package com.nano.composeapp.sealed

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created By Neeraj Yadav on 11/09/24
 */
sealed class IconSource {
    data class VectorIcon(val imageVector: ImageVector) : IconSource()
    data class BitmapIcon(val imageBitmap: ImageBitmap) : IconSource()
    data class PainterIcon(val painter:Painter) : IconSource()
}