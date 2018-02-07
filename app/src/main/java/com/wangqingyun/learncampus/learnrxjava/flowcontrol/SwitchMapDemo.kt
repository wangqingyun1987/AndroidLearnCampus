package com.wangqingyun.learncampus.learnrxjava.flowcontrol

import android.util.Log
import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 07/02/2018.
 */

private fun trySwitchMap() {
    val obRand = Observable.just("A", "B", "C", "D", "E", "F", "G")
            .concatMap {
                Observable.just(it).delay((Math.abs(Random().nextInt() % 50) + 50).toLong(), TimeUnit.MILLISECONDS)
            }

    Observable.interval(300, TimeUnit.MILLISECONDS)
            .take(5)
            .switchMap {
                count -> obRand.map { "${count + 1}--$it" }
            }
            .subscribe {
                Log.d("WQY", "received: $it")
            }
}

fun demoSwitchMap() {
    trySwitchMap()
}