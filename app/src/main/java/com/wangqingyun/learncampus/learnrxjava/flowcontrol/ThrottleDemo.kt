package com.wangqingyun.learncampus.learnrxjava.flowcontrol

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 07/02/2018.
 */

private fun tryThrottleLast() {
    Observable.concat(
            Observable.interval(100, TimeUnit.MILLISECONDS).take(20).map { "A-${it + 1}" },
            Observable.interval(300, TimeUnit.MILLISECONDS).take(8).map { "B-${it + 1}" },
            Observable.interval(200, TimeUnit.MILLISECONDS).take(10).map { "C-${it + 1}" }
    )
            .delay(850, TimeUnit.MILLISECONDS)
            .throttleLast(1000, TimeUnit.MILLISECONDS)
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

fun demoThrottle() {
    tryThrottleLast()
}