package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 28/01/2018.
 */

fun tryConcatMap() {
    Observable.just(100, 10, 30, 120)
            .concatMap {
                del -> Observable.interval(del.toLong(), TimeUnit.MILLISECONDS).take(1)
                    .map { del }
            }
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

fun tryConcatMapDemo() {
    tryConcatMap()
}