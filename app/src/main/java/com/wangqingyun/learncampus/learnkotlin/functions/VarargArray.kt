package com.wangqingyun.learncampus.learnkotlin.functions

import android.util.Log

/**
 * Created by qingyun.wang on 17/01/2018.
 */

fun displayAll(vararg textArray: String) = textArray.joinToString()

fun tryVarargArray() {
    val countryArray = arrayOf("契丹", "女真", "蒙古")
    Log.d("WQY", "--> ${displayAll(*countryArray)}")
}