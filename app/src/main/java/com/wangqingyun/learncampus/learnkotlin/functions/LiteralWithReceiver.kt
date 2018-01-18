package com.wangqingyun.learncampus.learnkotlin.functions

import android.util.Log

/**
 * Created by wangqingyun on 18/01/2018.
 */

class DemoDragon {
    fun max() = 9

    fun fire(): String {
        return "Dragon Fire"
    }
}

fun emitFire(cct: DemoDragon.(Int) -> Int): String {
    val dragon = DemoDragon()
    return "${dragon.cct(100)} ${dragon.fire()}"
}

fun tryLiteralWithReceiver() {
    val samp1 = fun (dragon: DemoDragon, count: Int) = count - dragon.max() - 3
    val samp2 = fun DemoDragon.(count: Int) = count % this.max()

    Log.d("WQY", "fun lit rec --> ${emitFire(samp1)}")
    Log.d("WQY", "fun lit rec --> ${emitFire(samp2)}")
    Log.d("WQY", "fun lit rec --> ${emitFire { 99 }}")
}