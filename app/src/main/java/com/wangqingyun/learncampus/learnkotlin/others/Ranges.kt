package com.wangqingyun.learncampus.learnkotlin.others

/**
 * Created by wangqingyun on 18/01/2018.
 *
 * Ranges implement a common interface in the library: ClosedRange<T>
 */

fun tryRanges() {
    val num  = 10
    val note = if (num in 1..20) "Germany" else "Russia"

    var sum = 0
    for (i in 1..100) {
        sum += i
    }

    var product = 1
    for (i in 10 downTo 5) {
        product *= i
    }

    var concat = ""
    for (i in 1..10 step 3) {
        concat += i
    }

    for (i in 1 until 20) {

    }
}