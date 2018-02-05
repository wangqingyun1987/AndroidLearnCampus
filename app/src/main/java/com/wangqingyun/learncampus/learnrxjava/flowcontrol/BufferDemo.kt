package com.wangqingyun.learncampus.learnrxjava.flowcontrol

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 05/02/2018.
 */

private fun tryBufferFixedSize() {
    Observable.interval(100, TimeUnit.MILLISECONDS)
            .take(30)
            .buffer(5)
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

fun demoBuffer() {
    tryBufferFixedSize()
}