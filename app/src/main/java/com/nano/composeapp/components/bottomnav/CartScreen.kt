package com.nano.composeapp.components.bottomnav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.constraintlayout.compose.ConstraintLayout
import com.nano.composeapp.R
import com.nano.composeapp.food.components.CardDelivery
import com.nano.composeapp.food.components.CartFoodList
import com.nano.composeapp.sealed.BottomNavigationScreens
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Screen on 20/09/24
 */

@Composable
fun CartScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        ConstraintLayout(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
        ) {

            val (cardDelivery,testCount,listCart,
                buttonOrder) = createRefs()

            CardDelivery(
                modifier = Modifier.constrainAs(cardDelivery){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }.shadow(
                        elevation = 40.dp,
                        ambientColor = Color.Red, // Custom shadow color
                        spotColor = Color.Blue   // Custom spot color (light sources)
                    ).padding(top = 10.dp)
            )
            Text(
                modifier = Modifier.padding(top = 20.dp)
                    .constrainAs(testCount){
                        top.linkTo(cardDelivery.bottom)
                        start.linkTo(parent.start, margin = 10.dp)
                    },
                text = "Your Order (4)",
                fontSize = 18.sp,
                fontFamily = notoSansFontFamily,
                fontWeight = FontWeight.Bold
            )

            CartFoodList(
                modifier = Modifier.padding(top = 20.dp)
                    .fillMaxHeight(0.6f)
                    .constrainAs(listCart){
                        top.linkTo(testCount.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(buttonOrder.top, margin = 10.dp)
                    }
            )

            ElevatedButton(
                onClick = {  },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.food_theme)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(buttonOrder){
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
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

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CartScreenPreview(){
    CartScreen()
}