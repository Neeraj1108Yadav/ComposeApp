package com.nano.composeapp.components.bottomnav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nano.composeapp.food.components.CardDelivery
import com.nano.composeapp.food.components.CardDiscount
import com.nano.composeapp.food.components.LazyFoodList
import com.nano.composeapp.food.components.SearchView
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 20/09/24
 */

@Composable
fun HomeScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            SearchView()
            Spacer(modifier = Modifier.padding(top = 10.dp))
            CardDelivery()
            CardDiscount()
            Text(
                text = "Top Of Week",
                fontSize = 18.sp,
                fontFamily = notoSansFontFamily,
                fontWeight = FontWeight.W800,
                color = Color.Black,
                modifier = Modifier.padding(top = 20.dp)
            )
            LazyFoodList()
            CardDiscount()

        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}