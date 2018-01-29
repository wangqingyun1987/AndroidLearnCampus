package com.wangqingyun.learncampus.learnrxjava.stream_type_convert

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 29/01/2018.
 */

fun tryAndThen() {
    Completable.timer(50, TimeUnit.MILLISECONDS)
            .andThen(Observable.range(1, 3))
            .map {
                "item at $it"
            }
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

fun demoCompletableToOthers() {
    tryAndThen()
}