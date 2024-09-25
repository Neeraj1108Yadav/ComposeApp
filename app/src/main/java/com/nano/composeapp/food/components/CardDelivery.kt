package com.nano.composeapp.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nano.composeapp.R
import com.nano.composeapp.graphics.SemiArc
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 22/09/24
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDelivery(){
    ElevatedCard(
        onClick = {  },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 40.dp
        ),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.food_theme)
        ),
        modifier = Modifier.shadow(
            elevation = 40.dp,
            ambientColor = Color.Red, // Custom shadow color
            spotColor = Color.Blue   // Custom spot color (light sources)
        ).padding(top = 10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,) {
            Column(
                modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)
            ){
                Text(
                    text = "Delivery to Home",
                    fontSize = 20.sp,
                    fontFamily = notoSansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = "Bako Street no 14, Ruptal",
                    fontSize = 14.sp,
                    fontFamily = notoSansFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )

                Box(modifier = Modifier
                    .padding(top = 8.dp, bottom = 15.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp)
                    )){
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "2.4 Km",
                        fontSize = 14.sp,
                        fontFamily = notoSansFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.food_theme)
                    )
                }
            }
            Column {
                IconButton(
                    modifier = Modifier.align(Alignment.End),
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                }
                SemiArc()
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CardDeliveryPreview(){
    CardDelivery()
}