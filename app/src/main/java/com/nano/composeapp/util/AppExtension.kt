package com.nano.composeapp.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nano.composeapp.model.CartModel
import com.nano.composeapp.model.FoodModel
import com.nano.composeapp.model.ProductModel

/**
 * Created By Neeraj Yadav on 16/09/24
 */

fun parseJsonToModel(jsonString:String):List<ProductModel>{
    val gson = Gson()
    return gson.fromJson(jsonString,object : TypeToken<List<ProductModel>>() {}.type)
}

fun parseFoodJsonToModel(jsonString:String):List<FoodModel>{
    val gson = Gson()
    return gson.fromJson(jsonString,object : TypeToken<List<FoodModel>>() {}.type)
}

fun parseCartJsonModel(jsonString:String):List<CartModel>{
    val gson = Gson()
    return gson.fromJson(jsonString,object : TypeToken<List<CartModel>>() {}.type)
}

fun getDrawableResourceId(context: Context,resourceName:String):Int{
    return context.resources.getIdentifier(resourceName,"drawable",context.packageName)
}