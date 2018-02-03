package com.wangqingyun.learncampus.learnrxjava.cocurrencies

import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 03/02/2018.
 */

/**
 * demonstrate that subscribeOn has no effect when using with interval, because interval is already
 * working on a different thread
 * */
fun tryIntervalWithSubScribeOn() {
    Observable.interval(100, TimeUnit.MILLISECONDS)
            .take(5)
            .doOnSubscribe {
                Log.d("WQY", "on subscribe on ${Thread.currentThread().name}")
            }
            .subscribeOn(Schedulers.newThread())
            .subscribe {
                Log.d("WQY", "received $it on ${Thread.currentThread().name}")
            }
}

fun demoSubscribeOn() {
    tryIntervalWithSubScribeOn()
}