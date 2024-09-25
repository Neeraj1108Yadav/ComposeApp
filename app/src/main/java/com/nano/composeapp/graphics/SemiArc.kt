package com.nano.composeapp.graphics

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nano.composeapp.R

/**
 * Created By Neeraj Yadav on 25/09/24
 */
@Composable
fun SemiArc() {
    val color = colorResource(id = R.color.arc_color)
    Canvas(
        modifier = Modifier.width(150.dp).height(60.dp).background(Color.Transparent)
    ) {
        val width = size.width
        val height = size.height
        val arcBrush = Brush.sweepGradient(
            colors = listOf(color,color)
        )
        drawArc(
            brush = arcBrush,
            topLeft = Offset(width / 4f, height / 3f),
            startAngle = 180f, // 180 represents 9'0 clock
            sweepAngle = 120f, // size of the arc
            useCenter = false,
            style = Stroke(width = 60f, cap = StrokeCap.Round),
            size = Size(350f, 350f),
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SemiArcPreview(){
    SemiArc()
}