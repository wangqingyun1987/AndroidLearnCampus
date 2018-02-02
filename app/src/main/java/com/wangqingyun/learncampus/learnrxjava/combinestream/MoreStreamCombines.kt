package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 02/02/2018.
 */

fun trySwitchMap() {
    Observable.interval(100, TimeUnit.MILLISECONDS)
            .take(5)
            .map { it + 1 }
            .switchMap {
                key ->
                Observable.interval(30, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map { "$key -> $it" }
            }
            .subscribe {
                Log.d("WQY", "switch map received : $it")
            }
}

fun demoMoreStreamCombinations() {
    trySwitchMap()
}