package com.wangqingyun.learncampus.learnkotlin.inlinefun

import android.util.Log

/**
 * Created by wangqingyun on 18/01/2018.
 */

inline fun <reified T> check(t: T): Boolean {
    return "A" is T
}

fun tryReified() {
    Log.d("WQY", "reified --> ${check("A")}")
    Log.d("WQY", "reified --> ${check(10)}")
}