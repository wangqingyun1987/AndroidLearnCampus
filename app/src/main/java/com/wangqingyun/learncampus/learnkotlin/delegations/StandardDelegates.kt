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

class VetoSample {
    var name: String by Delegates.vetoable("嘉靖") {
        property, oldValue, newValue ->
        Log.d("WQY", "$property wants to change from $oldValue to $newValue")
        newValue.length == 2
    }

    fun work() {
        name = "万历"
        Log.d("WQY", "name now : $name")
        name = "张居正"
        Log.d("WQY", "name now : $name")
        name = "隆庆"
        Log.d("WQY", "name now : $name")
    }
}

fun tryStandardDelegates() {
    LazySample().work()
    ObservableSample().work()
    VetoSample().work()
}