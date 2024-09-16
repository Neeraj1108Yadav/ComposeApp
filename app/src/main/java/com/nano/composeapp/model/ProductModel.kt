package com.nano.composeapp.model

import com.google.gson.annotations.SerializedName

/**
 * Created By Neeraj Yadav on 16/09/24
 */
data class ProductModel(
    @SerializedName("id")
    val productId:Int,
    @SerializedName("image")
    val productImage:String,
    @SerializedName("name")
    val productName:String,
    @SerializedName("category")
    val productCategory:String,
    @SerializedName("price")
    val productPrice:String,
    @SerializedName("rating")
    val productRating:Float
)
