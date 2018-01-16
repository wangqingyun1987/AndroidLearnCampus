package com.wangqingyun.learncampus.learnkotlin.generics

import android.util.Log

/**
 * Created by qingyun.wang on 16/01/2018.
 */

fun trySampleGeneric() {
    SampleGeneric(1002).work()
}

class SampleGeneric<T>(val t: T) {
    fun work() {
        Log.d("WQY", "generic : $t")
    }
}