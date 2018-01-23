package com.wangqingyun.learncampus.learnrxjava.transformoperators

import android.util.Log
import io.reactivex.Observable

/**
 * Created by wangqingyun on 23/01/2018.
 */

fun tryMap() {
    Observable.range(1, 3)
            .map { "item : $it" }
            .subscribe { Log.d("WQY", "mapped item: $it") }
}

fun tryMapOperators() {
    tryMap()
}