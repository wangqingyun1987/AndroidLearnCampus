package com.wangqingyun.learncampus.learnkotlin.others

import android.util.Log

/**
 * Created by wangqingyun on 18/01/2018.
 */

data class Person(val name: String, val age: Int)

fun tryDestructing() {
    val person = Person("Beckham", 39)

    val (x1, x2) = person
    Log.d("WQY", "--> $x1, $x2")
}