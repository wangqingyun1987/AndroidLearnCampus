package com.wangqingyun.learncampus.learnkotlin.delegations

import android.util.Log

/**
 * Created by qingyun.wang on 17/01/2018.
 */

class LazySample {
    val value: String by lazy {
        "大秦帝国"
    }

    fun work() {
        Log.d("WQY", "lazy 1 --> $value")
        Log.d("WQY", "lazy 2 --> $value")
    }
}

fun tryStandardDelegates() {
    LazySample().work()
}