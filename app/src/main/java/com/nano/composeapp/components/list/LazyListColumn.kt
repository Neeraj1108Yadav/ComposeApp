package com.nano.composeapp.components.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nano.composeapp.R
import com.nano.composeapp.model.ProductModel
import com.nano.composeapp.ui.theme.notoSansFontFamily
import com.nano.composeapp.util.ReadJsonAsset
import com.nano.composeapp.util.parseJsonToModel

/**
 * Created By Neeraj Yadav on 16/09/24
 */

@Composable
fun LazyListColumn(){
    Scaffold {innerPadding ->
        val productString = ReadJsonAsset.getFileFromAssets(LocalContext.current,"product.json")
        val product = parseJsonToModel(productString)
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            itemsIndexed(
                items = product,
                key = {index,item->
                    item.productId
                },
                itemContent = {index, item ->
                    ProductCard(product = item)
                })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(product:ProductModel){
    ElevatedCard(
        onClick = { },
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        ConstraintLayout{
            val (productImage,productName,productCategory,
                productPrice,ratingPrice) = createRefs()

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.productImage)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.user),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(productImage) {
                        start.linkTo(parent.start, margin = 10.dp)
                        top.linkTo(parent.top, margin = 15.dp)
                        end.linkTo(productName.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .width(72.dp)
                    .height(72.dp)
            )

            Text(
                modifier = Modifier
                    .constrainAs(productName) {
                        top.linkTo(productImage.top)
                        start.linkTo(productImage.end, margin = 10.dp)
                        end.linkTo(parent.end,margin = 10.dp)
                        width = Dimension.wrapContent
                    },
                text = product.productName,
                fontFamily = notoSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )

            Text(
                modifier = Modifier
                    .constrainAs(productCategory) {
                        top.linkTo(productName.bottom, margin = 5.dp)
                        start.linkTo(productName.start)
                        width = Dimension.wrapContent
                    },
                text = product.productCategory,
                fontFamily = notoSansFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.constrainAs(ratingPrice){
                    top.linkTo(productCategory.bottom, margin = 5.dp)
                    start.linkTo(productName.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                    .background(Color.Blue)
            ) {
                Text(
                    text = product.productPrice,
                    fontFamily = notoSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White
                )

                Text(
                    text = "Rating : ${product.productRating}",
                    fontFamily = notoSansFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.Yellow,
                    modifier = Modifier.background(Color.Red)
                )
            }
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun LazyListColumnPreview(){
    LazyListColumn()
}
