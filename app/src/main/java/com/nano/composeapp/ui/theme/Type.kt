package com.nano.composeapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nano.composeapp.R

// Set of Material typography styles to start with
val notoSansFontFamily = FontFamily(
   Font(R.font.noto_sans_thin,FontWeight.Thin),
   Font(R.font.noto_sans_regular,FontWeight.Normal),
   Font(R.font.noto_sans_light,FontWeight.Light),
   Font(R.font.noto_sans_semi_bold,FontWeight.Bold),
   Font(R.font.noto_sans_semi_bold,FontWeight.SemiBold),
   Font(R.font.noto_sans_extra_bold,FontWeight.ExtraBold),
   Font(R.font.noto_sans_medium,FontWeight.Medium)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = notoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = notoSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = notoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = notoSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    )
)