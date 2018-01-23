package com.wangqingyun.learncampus.learnrxjava

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

fun tryCast() {
    Observable.just("A", "B")
            .cast(Any::class.java).subscribe()
}

fun tryStartWith() {
    Observable.just("Chelsea", "Man City", "Man Utd")
            .startWith("Liverpool")
            .subscribe { Log.d("WQY", "Premier league team: $it") }
}

fun tryStartWithArray() {
    Observable.just("赵国", "魏国", "齐国")
            .startWithArray("秦国", "楚国")
            .subscribe { Log.d("WQY", "大国争霸 : $it") }
}

fun tryTransformOperators() {
    tryMap()

    tryCast()

    tryStartWith()
    tryStartWithArray()
}