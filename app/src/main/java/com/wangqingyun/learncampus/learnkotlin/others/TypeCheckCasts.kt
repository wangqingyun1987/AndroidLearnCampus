@file:Suppress("USELESS_IS_CHECK", "CAST_NEVER_SUCCEEDS", "USELESS_CAST")

package com.wangqingyun.learncampus.learnkotlin.others

/**
 * Created by wangqingyun on 18/01/2018.
 */

private class Dragon

private class Tank

fun tryTypeChecks() {
    val text = "A"
    val isText = text is String
    val isNotText = text !is String
}

fun checkUp(any: Any) = any is List<*>

fun trySafeCast() {
    val dragon = Dragon()
    val tank = Tank()

    val vehicle: Dragon? = dragon as? Dragon
    val vix: Dragon? = tank as? Dragon // vix will be null

    val list = listOf("A", "B", "C")
    if (checkUp(list)) {}
}