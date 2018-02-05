package com.wangqingyun.learncampus.learnrxjava.flowcontrol

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 05/02/2018.
 */

private fun tryBufferFixedSize() {
    Observable.interval(100, TimeUnit.MILLISECONDS)
            .take(32)
            .buffer(5)
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

private fun tryBufferFixedSizeRolling() {
    Observable.range(1, 10)
            .buffer(2, 1)
            .subscribe {
                Log.d("WQY", "received $it")
            }
}

private fun tryBufferTimeBased() {
    Observable.interval(30, TimeUnit.MILLISECONDS)
            .take(30)
            .buffer(100, TimeUnit.MILLISECONDS)
            .subscribe {
                Log.d("WQY", "buffer received $it")
            }
}

fun demoBuffer() {
    tryBufferFixedSize()
    tryBufferFixedSizeRolling()

    tryBufferTimeBased()
}