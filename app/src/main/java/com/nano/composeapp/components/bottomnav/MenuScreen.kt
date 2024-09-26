package com.nano.composeapp.components.bottomnav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nano.composeapp.R
import com.nano.composeapp.food.components.GridFoodList
import com.nano.composeapp.food.components.MediumTextCompose
import com.nano.composeapp.food.components.SearchView
import com.nano.composeapp.food.components.TabFoodChoice
import com.nano.composeapp.sealed.BottomNavigationScreens
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 20/09/24
 */

@Composable
fun MenuScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
        ){
           Text(
               modifier = Modifier.padding(top = 5.dp),
               text = "Our Food",
               color = colorResource(id = R.color.placeholder_color),
               fontFamily = notoSansFontFamily,
               fontSize = 16.sp,
               fontWeight = FontWeight.W700
           )

            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 20.dp),
                text = "Special For You",
                color = colorResource(id = R.color.food_theme),
                fontFamily = notoSansFontFamily,
                fontSize = 22.sp,
                fontWeight = FontWeight.W900
            )

            SearchView()
            TabFoodChoice()
            GridFoodList()
        }

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MenuScreenPreview(){
    MenuScreen()
}
