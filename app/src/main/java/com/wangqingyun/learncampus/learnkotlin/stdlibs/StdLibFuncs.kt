package com.wangqingyun.learncampus.learnkotlin.stdlibs

import android.annotation.SuppressLint
import android.util.Log

@SuppressLint("LogNotTimber")
        /**
 * Created by qingyun.wang on 02/02/2018.
 */

fun tryAny() {
    val list = listOf("Arsenal", "Barcelona", "AC Milan")

    Log.d("WQY", "${list.any { it.length == 7 }}")
    Log.d("WQY", "${list.any { it.length == 10 }}")
}

fun demoStdLibFunctions() {
    tryAny()
}