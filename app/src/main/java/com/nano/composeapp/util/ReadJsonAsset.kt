package com.nano.composeapp.util

import android.content.Context

/**
 * Created By Neeraj Yadav on 16/09/24
 */
object ReadJsonAsset {

    fun getFileFromAssets(context: Context,fileName:String):String{
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}