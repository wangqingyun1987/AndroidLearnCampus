package com.wangqingyun.learncampus.learnkotlin.delegations

import android.util.Log

/**
 * Created by qingyun.wang on 17/01/2018.
 */

fun display(gen: () -> String) {
    val text: String by lazy { gen() }

    Log.d("WQY", "display: $text")
}

fun tryLocalDelegates() {
    display { "宋仁宗与包拯的基情" }
}