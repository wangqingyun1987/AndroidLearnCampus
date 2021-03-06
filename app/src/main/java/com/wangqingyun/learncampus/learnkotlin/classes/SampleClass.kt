package com.wangqingyun.learncampus.learnkotlin.classes

/**
 * Created by wangqingyun on 13/01/2018.
 */

class SampleClass {
    var myName = ""
    var name: String
        get() = "A"
        set(text) {
            myName = text
        }

    val age: Int
        get() = 101

    var gender: String = "m"
        set(value) {
            field = if (value.startsWith("m")) "m" else "f"
        }
}