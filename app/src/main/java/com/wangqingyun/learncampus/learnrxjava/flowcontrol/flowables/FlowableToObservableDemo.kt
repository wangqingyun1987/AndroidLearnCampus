package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables

import android.util.Log
import io.reactivex.Flowable

/**
 * Created by wangqingyun on 09/02/2018.
 */

/**
 * Flowable.toObservable will simply request(Long.MAX_VALUE) in onSubscribe()
 * */
private fun tryRange() {
    val flowable = Flowable.range(1, 100)

    flowable.toObservable()
            .subscribe {
                Log.d("WQY", "received $it")
            }
}

fun demoFlowableToObservable() {
    tryRange()
}