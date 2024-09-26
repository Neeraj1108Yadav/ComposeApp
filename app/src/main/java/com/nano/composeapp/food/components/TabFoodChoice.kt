package com.nano.composeapp.food.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
fun TabFoodChoice() {

    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Featured", "Top of Week", "Soup","Seafood")

    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        divider = {},
        edgePadding = 0.dp,
        modifier = Modifier.padding(top = 10.dp),
    ) {
        tabTitles.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index },
                text = {
                    Text(
                        text = title,
                        fontSize = if(selectedTabIndex == index) 16.sp else 14.sp,
                        fontFamily = notoSansFontFamily,
                        fontWeight = if(selectedTabIndex == index) FontWeight.W800 else FontWeight.Bold,
                        color = if(selectedTabIndex == index) Color.Black else colorResource(id = R.color.placeholder_color)
                    )
                }
            )
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TabFoodChoicePreview() {
    TabFoodChoice()
}