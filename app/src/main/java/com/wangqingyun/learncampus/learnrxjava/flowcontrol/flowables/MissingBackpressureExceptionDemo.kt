package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 08/02/2018.
 */

private fun tryFlowableInterval() {
    Flowable.interval(100, TimeUnit.MILLISECONDS)
            .observeOn(Schedulers.newThread())
            .subscribe ({
                Thread.sleep(200)
            }, {
                Log.d("WQY", "error")
                it.printStackTrace()
            })
}

fun demoMissingBackpressureException() {
    tryFlowableInterval()
}