package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable

/**
 * Created by wangqingyun on 25/01/2018.
 */

fun tryDoOnNext() {
    Observable.just("Man City", "Man Utd", "Liverpool", "Arsenal")
            .doOnNext { Log.d("WQY", "do on next : $it") }
            .map { it.length }
            .subscribe { Log.d("WQY", "received : $it") }
}

fun tryDoOnComplete() {
    Observable.just("Ronaldo", "Beckham", "Zidanei")
            .doOnComplete {
                Log.d("WQY", "do on complete")
            }
            .subscribe({
                Log.d("WQY", "received : $it")
            }, {
                Log.d("WQY", "error : ${it.message}")
            }, {
                Log.d("WQY", "on complete")
            })
}

fun tryDoOnOperators() {
    tryDoOnNext()
    tryDoOnComplete()
}