package com.nano.composeapp.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nano.composeapp.R
import com.nano.composeapp.model.CartModel
import com.nano.composeapp.ui.theme.notoSansFontFamily
import com.nano.composeapp.util.ReadJsonAsset
import com.nano.composeapp.util.getDrawableResourceId
import com.nano.composeapp.util.parseCartJsonModel

/**
 * Created By Neeraj Yadav on 26/09/24
 */

@Composable
fun CartFoodList(modifier: Modifier) {
    val foodString = ReadJsonAsset.getFileFromAssets(LocalContext.current,"cart.json")
    val foodInCart= parseCartJsonModel(foodString)
    LazyColumn(modifier = modifier) {
        itemsIndexed(
            items = foodInCart,
            key = {index,item->
                item.foodId
            },
            itemContent = {index, item ->
                FoodCartItem(item)
            })
    }
}

@Composable
fun FoodCartItem(cartModel: CartModel){
    val context = LocalContext.current
    val imageResId = remember {
        getDrawableResourceId(context, cartModel.image)
    }
    Card(
        modifier = Modifier.padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(){
            Box(modifier = Modifier.weight(1f)){
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .height(80.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            Box(modifier = Modifier
                .weight(3f)
                .fillMaxSize()){
                Column(modifier = Modifier.padding(
                    start = 15.dp,
                    end = 10.dp,
                    top = 10.dp,
                    bottom = 10.dp
                )) {
                    Text(
                        text = cartModel.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = notoSansFontFamily
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        IconButton(
                            onClick = { }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.remove),
                                contentDescription = null
                            )
                        }

                        Text(
                            text = "${cartModel.quantity}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W800,
                            fontFamily = notoSansFontFamily
                        )

                        IconButton(
                            onClick = { }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.add),
                                contentDescription = null
                            )
                        }

                        Text(
                            text = cartModel.price,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W900,
                            fontFamily = notoSansFontFamily,
                            color = colorResource(id = R.color.food_theme)
                        )
                    }
                }
            }
        }
    }
}

/*@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CartFoodListPreview() {
    CartFoodList()
}*/