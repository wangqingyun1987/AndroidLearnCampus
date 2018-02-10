package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables.operators

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by wangqingyun on 10/02/2018.
 */

private fun tryFromIterable() {
    Flowable.fromIterable(1..10000)
            .observeOn(AndroidSchedulers.mainThread())
            .reduce {
                accum: Int, next: Int ->
                Thread.sleep(1)
                accum + next
            }
            .subscribe {
                Log.d("WQY", "sum : $it")
            }
}

fun demoFlowableFromIterable() {
    tryFromIterable()
}