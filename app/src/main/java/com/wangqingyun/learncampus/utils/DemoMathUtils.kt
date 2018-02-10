package com.wangqingyun.learncampus.utils

/**
 * Created by wangqingyun on 08/02/2018.
 */

fun Int.isPrime(): Boolean {
    val upper = Math.sqrt(toDouble()).toInt()

    return (2..upper).none { this % it == 0 }
}

fun  Int.nextPrime(): Int {
    var number = this + 1

    while (!number.isPrime()) number++

    return number
}