package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable

/**
 * Created by wangqingyun on 25/01/2018.
 */

fun tryDoOnNext() {
    Observable.just("Man City", "Man Utd", "Liverpool", "Arsenal")
            .doOnNext { Log.d("WQY", "do on next : $it") }
            .map { it.length }
            .subscribe { Log.d("WQY", "received : $it") }
}

fun tryDoOnOperators() {
    tryDoOnNext()
}