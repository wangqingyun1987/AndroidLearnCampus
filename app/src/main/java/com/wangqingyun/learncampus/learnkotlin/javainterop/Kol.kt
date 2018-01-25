package com.wangqingyun.learncampus.learnkotlin.javainterop

/**
 * Created by wangqingyun on 25/01/2018.
 */

object Kobj {
    val attri = "NONE"

    @JvmField
    val count = 10

    @JvmStatic
    val member = 101
}

class Kol {
    companion object {
        val name = "Ali"

        @JvmField
        val gender = "Male"

        fun toBj() {}

        @JvmStatic
        fun toSg() {}
    }

    val weight = 70

    @JvmField
    val height = 180
}