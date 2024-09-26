package com.nano.composeapp.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nano.composeapp.R
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 25/09/24
 */
@Composable
fun CardFavorite() {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.food_theme)
        ),
        modifier = Modifier
            .padding(top = 20.dp)
            .height(200.dp)
    ) {
        ConstraintLayout {
            val (image,description) = createRefs()
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .constrainAs(image){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    },
                painter = painterResource(id = R.drawable.banner),
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .constrainAs(description){
                        top.linkTo(parent.top, margin = 20.dp)
                        start.linkTo(parent.start, margin = 20.dp)
                        bottom.linkTo(parent.bottom, margin = 20.dp)
                    }
            ) {

                Text(
                    text = "Yakitori",
                    fontSize = 24.sp,
                    fontFamily = notoSansFontFamily,
                    fontWeight = FontWeight.W800,
                    color = colorResource(id = R.color.white)
                )

                Text(
                    modifier = Modifier.padding(top = 5.dp)
                        .width(150.dp),
                    text = "These Grilled chicken " +
                            "skewers are a favorite among after work diners " +
                            "with a few beers!",
                    fontSize = 15.sp,
                    fontFamily = notoSansFontFamily,
                    fontWeight = FontWeight.W700,
                    color = colorResource(id = R.color.white)
                )
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