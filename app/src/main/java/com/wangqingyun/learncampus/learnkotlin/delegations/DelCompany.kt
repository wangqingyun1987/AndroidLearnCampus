package com.wangqingyun.learncampus.learnkotlin.delegations

import android.util.Log
import kotlin.reflect.KProperty

/**
 * Created by qingyun.wang on 17/01/2018.
 */

class Panasonic {
    private var value = ""

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "Pan: $value"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, v: String) {
        value = v
    }
}

class GeneralE {
    var text: String by Panasonic()

    fun work() {
        text = "Radio Receiver KH7"

        Log.d("WQY", "radio prototype: $text")
    }
}

fun tryDelegatedProperty() {
    GeneralE().work()
}