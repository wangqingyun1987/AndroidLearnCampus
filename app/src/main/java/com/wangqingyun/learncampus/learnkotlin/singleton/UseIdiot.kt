package com.wangqingyun.learncampus.learnkotlin.singleton

import android.util.Log

/**
 * Created by wangqingyun on 11/01/2018.
 */

class UseIdiot {
    fun useIt() {
        Log.d("WQY", "--> ${IdiotManager.work()}")
    }
}