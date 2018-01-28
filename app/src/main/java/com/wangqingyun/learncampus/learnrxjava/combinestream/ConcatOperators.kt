package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 28/01/2018.
 */

fun tryConcat() {
    val obA: Observable<String> = Observable.interval(500L, TimeUnit.MILLISECONDS)
            .map {
                "A : $it"
            }
            .take(2)

    val obB = Observable.interval(300L, TimeUnit.MILLISECONDS)
            .map {
                "B : $it"
            }
            .take(3)

    Observable.concat(obA, obB)
            .subscribe {
                Log.d("WQY", "concatenated : $it")
            }
}

fun tryConcatenationOperators() {
    tryConcat()
}