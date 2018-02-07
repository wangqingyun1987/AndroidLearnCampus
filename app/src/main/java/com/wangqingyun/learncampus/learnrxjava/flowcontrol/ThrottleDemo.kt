package com.wangqingyun.learncampus.learnrxjava.flowcontrol

import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 07/02/2018.
 */

private fun tryThrottleLast() {
    Observable.concat(
            Observable.interval(100, TimeUnit.MILLISECONDS).take(20).map { "A-${it + 1}" },
            Observable.interval(300, TimeUnit.MILLISECONDS).take(8).map { "B-${it + 1}" },
            Observable.interval(200, TimeUnit.MILLISECONDS).take(10).map { "C-${it + 1}" }
    )
            .delay(850, TimeUnit.MILLISECONDS)
            .throttleLast(1000, TimeUnit.MILLISECONDS)
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

/**
 * sample is just an alis of throttleLast
 * */
private fun trySample() {
    Observable.interval(100, TimeUnit.MILLISECONDS)
            .map { it +1 }
            .take(20)
            .sample(600, TimeUnit.MILLISECONDS, Schedulers.computation(), true)
            .subscribe {
                Log.d("WQY", "sample received : $it")
            }
}

private fun tryThrottleFirst() {
    Observable.interval(100, TimeUnit.MILLISECONDS)
            .map { it + 1 }
            .take(20)
            .throttleFirst(770, TimeUnit.MILLISECONDS)
            .subscribe {
                Log.d("WQY", "throttle first : $it")
            }
}

/**
 * for completeness, we used sample() here instead of throttleLast()
 * */
private fun compareThrottleLastAndFirst() {
    val observableFirst = Observable.concat(
            Observable.interval(800, TimeUnit.MILLISECONDS)
                    .map { "A" }
                    .take(1),
            Observable.interval(300, TimeUnit.MILLISECONDS)
                    .map { "B" }
                    .take(1),
            Observable.interval(1600, TimeUnit.MILLISECONDS)
                    .map { "C" }
                    .take(1)
    )
            .throttleFirst(1000, TimeUnit.MILLISECONDS)
            .doOnNext { Log.d("WQY", "throttle first : $it") }

    val observableLast = Observable.concat(
            Observable.interval(800, TimeUnit.MILLISECONDS)
                    .map { "A" }
                    .take(1),
            Observable.interval(300, TimeUnit.MILLISECONDS)
                    .map { "B" }
                    .take(1),
            Observable.interval(1600, TimeUnit.MILLISECONDS)
                    .map { "C" }
                    .take(1)
    )
            .sample(1000, TimeUnit.MILLISECONDS, Schedulers.computation(), true)
            .doOnNext { Log.d("WQY", "throttle last : $it") }

    Observable.concat(
            observableFirst,
            observableLast
    ).subscribe()
}

private fun tryThrottleWithTimeout() {
    Observable.concat(
            listOf(
                    Observable.interval(100, TimeUnit.MILLISECONDS).map { "A" }.take(1),
                    Observable.interval(600, TimeUnit.MILLISECONDS).map { "B" }.take(1),
                    Observable.interval(200, TimeUnit.MILLISECONDS).map { "C" }.take(1),
                    Observable.interval(350, TimeUnit.MILLISECONDS).map { "D" }.take(1),
                    Observable.interval(120, TimeUnit.MILLISECONDS).map { "E" }.take(1),
                    Observable.interval( 80, TimeUnit.MILLISECONDS).map { "F" }.take(1),
                    Observable.interval(150, TimeUnit.MILLISECONDS).map { "G" }.take(1),
                    Observable.interval(800, TimeUnit.MILLISECONDS).map { "H" }.take(1)
            )
    ).throttleWithTimeout(320, TimeUnit.MILLISECONDS)
            .subscribe {
                Log.d("WQY", "throttleWithTimeout : $it")
            }
}

/**
 * debounce() is an alias of throttleWithTimeout()
 * */
private fun tryDebounce() {
    Observable.concat(
            listOf(
                    Observable.interval(100, TimeUnit.MILLISECONDS).map { "A" }.take(1),
                    Observable.interval(600, TimeUnit.MILLISECONDS).map { "B" }.take(1),
                    Observable.interval(200, TimeUnit.MILLISECONDS).map { "C" }.take(1),
                    Observable.interval(350, TimeUnit.MILLISECONDS).map { "D" }.take(1),
                    Observable.interval(120, TimeUnit.MILLISECONDS).map { "E" }.take(1),
                    Observable.interval( 80, TimeUnit.MILLISECONDS).map { "F" }.take(1),
                    Observable.interval(150, TimeUnit.MILLISECONDS).map { "G" }.take(1),
                    Observable.interval(800, TimeUnit.MILLISECONDS).map { "H" }.take(1)
            )
    ).debounce(320, TimeUnit.MILLISECONDS)
            .subscribe {
                Log.d("WQY", "debounce : $it")
            }
}

fun demoThrottle() {
    tryThrottleLast()
    trySample()

    tryThrottleFirst()

    compareThrottleLastAndFirst()

    tryThrottleWithTimeout()
    tryDebounce()
}