package com.nano.composeapp.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nano.composeapp.model.ProductModel

/**
 * Created By Neeraj Yadav on 16/09/24
 */

fun parseJsonToModel(jsonString:String):List<ProductModel>{
    val gson = Gson()
    return gson.fromJson(jsonString,object : TypeToken<List<ProductModel>>() {}.type)
}