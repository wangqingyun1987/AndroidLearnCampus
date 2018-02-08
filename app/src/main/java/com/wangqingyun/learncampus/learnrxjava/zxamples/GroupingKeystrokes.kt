package com.wangqingyun.learncampus.learnrxjava.zxamples

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 08/02/2018.
 */

fun demoGroupingKeystrokes() {
    val mapHello = mapOf(
            1 to "H",
            2 to "e",
            3 to "l",
            4 to "l",
            5 to "o"
    )

    val mapWorld = mapOf(
            1 to "W",
            2 to "o",
            3 to "r",
            4 to "l",
            5 to "d"
    )

    val keyStrokes = Observable.concat(
            Observable.interval(100, TimeUnit.MILLISECONDS).take(5).map { it.toInt() }.map { mapHello[it + 1] },
            Observable.interval(600, TimeUnit.MILLISECONDS).take(1).skip(1),
            Observable.interval(100, TimeUnit.MILLISECONDS).take(5).map { it.toInt() }.map { mapWorld[it + 1] }
    ).map { "$it" }.publish().autoConnect()

    val restSignal = keyStrokes.debounce(500, TimeUnit.MILLISECONDS).startWith("")

    restSignal.switchMap {
        keyStrokes.scan { rolling: String, next: String -> rolling + next }
    }.subscribe {
        Log.d("WQY", "received : $it")
    }
}