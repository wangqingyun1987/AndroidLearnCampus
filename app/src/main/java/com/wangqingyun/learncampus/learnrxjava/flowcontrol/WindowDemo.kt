package com.wangqingyun.learncampus.learnrxjava.flowcontrol

import android.util.Log
import io.reactivex.Observable

/**
 * Created by wangqingyun on 05/02/2018.
 */

private fun tryWindowFixedSize() {
    Observable.range(1, 32)
            .window(10)
            .flatMapSingle<String> {
                it.reduce("") {
                    accum: String, next: Int -> if (accum.isEmpty()) "$next" else "$accum | $next"
                }
            }
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

fun demoWindow() {
    tryWindowFixedSize()
}