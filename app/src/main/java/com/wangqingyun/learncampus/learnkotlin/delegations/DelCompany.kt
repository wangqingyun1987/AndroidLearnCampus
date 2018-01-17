package com.wangqingyun.learncampus.learnkotlin.delegations

import android.util.Log
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by qingyun.wang on 17/01/2018.
 */

class Panasonic {
    private var value = ""

    /* thisRef in this case is the GenericE instance, while property is the field "text" */
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "Pan: $value"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, v: String) {
        value = v
    }
}

class Hitachi<in R>: ReadOnlyProperty<R, String> {
    override fun getValue(thisRef: R, property: KProperty<*>): String {
        return "Manufactured by Hitachi"
    }
}

class TCL<in R>: ReadWriteProperty<R, String> {
    private var storage = ""

    override fun getValue(thisRef: R, property: KProperty<*>): String {
        return storage
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: String) {
        storage = "TCL . $value"
    }
}

class GeneralE {
    var text:  String by Panasonic()
    val ttHit: String by Hitachi<GeneralE>()
    var ttCL:  String by TCL<GeneralE>()

    fun work() {
        text = "Radio Receiver KH7"
        ttCL = "TV Station"

        Log.d("WQY", "radio prototype: $text, $ttHit, $ttCL")
    }
}

fun tryDelegatedProperty() {
    GeneralE().work()
}