package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

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

fun tryDefaultIfEmpty() {
    Observable.empty<Int>()
            .defaultIfEmpty(303)
            .subscribe { Log.d("WQY", "default if empty : $it") }
}

fun trySwitchIfEmpty() {
    Observable.just("China", "Japan", "Korea")
            .filter { it.startsWith("z") }
            .switchIfEmpty(
                    Observable.just("Russia", "Germany", "France")
            )
            .subscribe {
                Log.d("WQY", "mitigation countries : $it")
            }
}

fun trySorted() {
    Observable.just("America", "Asia", "Africa", "Europe", "Australia")
            .sorted { o1, o2 -> o1.length - o2.length }
            .subscribe { Log.d("WQY", "sorted : $it") }
}

fun tryDelay() {
    Observable.just("Japan", "Germany", "Russia")
            .delay(1000, TimeUnit.MILLISECONDS)
            .subscribe { Log.d("WQY", "delay : $it") }
}

fun tryTransformOperators() {
    tryMap()

    tryCast()

    tryStartWith()
    tryStartWithArray()

    tryDefaultIfEmpty()
    trySwitchIfEmpty()

    trySorted()

    tryDelay()
}