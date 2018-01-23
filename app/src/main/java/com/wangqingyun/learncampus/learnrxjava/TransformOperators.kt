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

fun tryDelay2() {
    var count = 1

    Observable.just("BMW", "Mercedes", "Audi").delay {
        val ob = Observable.just(it).delay((500 * count).toLong(), TimeUnit.MILLISECONDS)
        count += 2
        ob
    }.subscribe {
        Log.d("WQY", "delayed per item : $it")
    }
}

fun tryDelaySubscription() {
    Observable.just("A", "B", "C").delaySubscription<String> (
        Observable.just("A").delay(2, TimeUnit.SECONDS)
    ).subscribe {
        Log.d("WQY", "delay subscription : $it")
    }
}

fun tryRepeat() {
    Observable.just("India", "Brazil", "Egypt")
            .repeat(2)
            .subscribe { Log.d("WQY", "repeat item : $it") }
}

fun tryScan() {
    Observable.range(1, 5)
            .scan { accumunlation: Int, next: Int -> accumunlation + next }
            .subscribe { Log.d("WQY", "scanned accumulation : $it") }
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
    tryDelay2()
    tryDelaySubscription()

    tryRepeat()

    tryScan()
}