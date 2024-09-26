package com.nano.composeapp.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nano.composeapp.R
import com.nano.composeapp.model.FoodModel
import com.nano.composeapp.ui.theme.notoSansFontFamily
import com.nano.composeapp.util.ReadJsonAsset
import com.nano.composeapp.util.getDrawableResourceId
import com.nano.composeapp.util.parseFoodJsonToModel

/**
 * Created By Neeraj Yadav on 25/09/24
 */
@Composable
fun GridFoodList() {
    val foodString = ReadJsonAsset.getFileFromAssets(LocalContext.current,"japanese.json")
    val japaneseFood = parseFoodJsonToModel(foodString)
    val featuredFood = japaneseFood.filter { it.featured }

    // LazyVerticalGrid with span count of 2
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Set span count to 2
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(featuredFood.size) { index ->
            FeaturedFood(foodModel = featuredFood[index])
        }
    }
}

@Composable
fun FeaturedFood(foodModel: FoodModel){
    val context = LocalContext.current
    val imageResId = remember {
        getDrawableResourceId(context, foodModel.image)
    }
    ElevatedCard(
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier.padding(end = 15.dp, bottom = 20.dp)) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Maintain square aspect ratio
            .background(Color.LightGray)){
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .fillMaxSize(),
                contentScale = ContentScale.Crop

            )
        }

        Text(
            text = foodModel.name,
            fontSize = 18.sp,
            fontFamily = notoSansFontFamily,
            fontWeight = FontWeight.W800,
            color = Color.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(
                start = 5.dp,
                end = 8.dp,
                top = 10.dp)
        )
        Row(
            modifier = Modifier
                .padding(
                    start = 5.dp,
                    end = 8.dp,
                    top = 5.dp,
                    bottom = 10.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = foodModel.price,
                fontSize = 16.sp,
                fontFamily = notoSansFontFamily,
                fontWeight = FontWeight.W900,
                color = colorResource(id = R.color.food_theme)
            )

            Icon(
                imageVector = if(foodModel.isFav) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = null,
                tint = if(foodModel.isFav) Color.Red else Color.Black
            )
        }

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GridFoodListPreview() {
    GridFoodList()
}