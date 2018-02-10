package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables.operators

import android.util.Log
import io.reactivex.BackpressureOverflowStrategy
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by wangqingyun on 10/02/2018.
 */

private fun tryPlainOne() {
    Flowable.interval(1, TimeUnit.MILLISECONDS)
            .take(1000)
            .onBackpressureBuffer()
            .observeOn(AndroidSchedulers.mainThread(), false, 8)
            .subscribe {
                Thread.sleep(10)
                Log.d("WQY", "received : $it")
            }
}

private fun tryWithDropOldest() {
    Observable.interval(1, TimeUnit.MILLISECONDS)
            .toFlowable(BackpressureStrategy.MISSING)
            .take(10000)
            .onBackpressureBuffer(10, object : Action {
                var printed = AtomicBoolean(false)
                override fun run() {
                    if (printed.compareAndSet(false, true)) {
                        Log.d("WQY", "overflow happens")
                    }
                }
            }, BackpressureOverflowStrategy.DROP_OLDEST)
            .observeOn(AndroidSchedulers.mainThread(), false, 8)
            .subscribe {
                Thread.sleep(10)
                Log.d("WQY", "received : $it")
            }
}

fun demoOnBackpressureBuffer() {
    tryPlainOne()

    tryWithDropOldest()
}