package com.wangqingyun.learncampus.learnkotlin.functions

import android.util.Log

/**
 * Created by qingyun.wang on 17/01/2018.
 */

open class DefBase {
    open fun work(value: String = "haha"): String {
        return "value is : $value"
    }
}

class DefDerive: DefBase() {
    override fun work(value: String): String {
        return "Derived value: $value"
    }
}

fun tryDefaultOverride() {
    Log.d("WQY", "--> ${DefDerive().work()}")
}