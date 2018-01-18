package com.wangqingyun.learncampus.learnkotlin.others

import android.util.Log

/**
 * Created by wangqingyun on 18/01/2018.
 */

data class Person(val name: String, val age: Int)

fun getTT(body: (Person) -> String) = "ok: ${body(Person("Ronaldo", 33))}"

fun tryDestructing() {
    val person = Person("Beckham", 39)
    val (x1, x2) = person
    Log.d("WQY", "--> $x1, $x2")

    val map = mapOf(
            "A" to "Japan",
            "B" to "Korea",
            "C" to "China"
    )
    for ((key, value) in map) {
        Log.d("WQY", "$key -> $value")
    }

    val tt = getTT { (name, age) -> "name: $name, age: $age" }
    Log.d("WQY", "--> $tt")
}