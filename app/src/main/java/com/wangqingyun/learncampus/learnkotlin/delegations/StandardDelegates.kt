package com.wangqingyun.learncampus.learnkotlin.delegations

import android.util.Log
import kotlin.properties.Delegates

/**
 * Created by qingyun.wang on 17/01/2018.
 */

class LazySample {
    // By default, the evaluation of lazy properties is synchronized
    val value: String by lazy {
        "大秦帝国"
    }

    fun work() {
        Log.d("WQY", "lazy 1 --> $value")
        Log.d("WQY", "lazy 2 --> $value")
    }
}

class ObservableSample {
    var text: String by Delegates.observable("东胡") {
        property, oldValue, newValue ->
        Log.d("WQY", "$property from $oldValue to $newValue")
    }

    fun work() {
        text = "匈奴"
        text = "突厥"
    }
}

fun tryStandardDelegates() {
    LazySample().work()

    ObservableSample().work()
}