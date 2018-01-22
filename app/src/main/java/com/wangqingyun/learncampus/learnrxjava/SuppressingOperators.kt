package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 22/01/2018.
 */

fun Int.isPrime(): Boolean {
    val upper = Math.sqrt(toDouble()).toInt()

    Log.d("WQY", "upper : $upper")

    return (2..upper).none {
        Log.d("WQY", "number : $this")
        this % it == 0
    }
}

fun tryFilter() {
    Observable.range(10, 10)
            .filter { it % 2 == 0 }
            .subscribe { Log.d("WQY", "even number : $it") }
}

fun tryTakeWithAccount() {
    Observable.just("Japan", "China", "Korea", "Russia", "India", "Thailand")
            .take(2)
            .subscribe { Log.d("WQY", "first two: $it") }
}

fun tryTakeWithTime() {
    Observable.interval(500, TimeUnit.MILLISECONDS)
            .take(2, TimeUnit.SECONDS)
            .subscribe { Log.d("WQY", "first two second : $it") }
}

fun trySkip() {
    Observable.range(1, 30)
            .skip(25)
            .subscribe { Log.d("WQY", "last of 30s : $it") }
}

fun tryTakeWhile() {
    Observable.range(300, 50).takeWhile { !it.isPrime() }
            .subscribe { Log.d("WQY", "none prime : $it") }
}

fun trySuppressing() {
    tryFilter()

    tryTakeWithAccount()
    tryTakeWithTime()

    trySkip()

    tryTakeWhile()
}