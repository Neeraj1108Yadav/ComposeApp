package com.nano.composeapp.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nano.composeapp.R
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 25/09/24
 */
@Composable
fun CardFavorite() {
    Card(
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.discount_card_bg)
        ),
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(13.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .height(120.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = null
                )
            }

            Column() {
                Text(
                    text = "Chicken Teriyaki",
                    fontSize = 24.sp,
                    fontFamily = notoSansFontFamily,
                    fontWeight = FontWeight.W900,
                    color = Color.Black
                )

                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = "Discount 25%",
                    fontSize = 18.sp,
                    fontFamily = notoSansFontFamily,
                    fontWeight = FontWeight.W800,
                    color = colorResource(id = R.color.arc_color)
                )

                ElevatedButton(
                    onClick = {  },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.food_theme)
                    ),
                    modifier = Modifier.padding(top = 5.dp)
                ) {
                    Text(
                        text = "Order Now",
                        fontSize = 16.sp,
                        fontFamily = notoSansFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CardFavoritePreview(){
    CardFavorite()
}