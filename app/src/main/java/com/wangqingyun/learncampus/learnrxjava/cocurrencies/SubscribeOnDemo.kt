package com.wangqingyun.learncampus.learnrxjava.cocurrencies

import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 03/02/2018.
 */

private fun tryBasicSubscribeOn() {
    Observable.just("AC Milan", "Bayern Munich", "Chelsea")
            .subscribeOn(Schedulers.io())
            .subscribe {
                Log.d("WQY", "received $it on ${Thread.currentThread().name}")
            }
}

/**
 * demonstrate when there's only one subscribeOn, it can be placed anywhere in the Observable chain
 * to have emission happen on it
 * */
private fun tryAnyWhereInChain() {
    Observable.just("A")
            .subscribeOn(Schedulers.computation())
            .map { it.length }
            .map { "length is $it" }
            .subscribe { Log.d("WQY", "anywhere received $it on ${Thread.currentThread().name}") }

    Observable.just("B")
            .map { it.length }
            .subscribeOn(Schedulers.computation())
            .map { "length is $it" }
            .subscribe { Log.d("WQY", "anywhere received $it on ${Thread.currentThread().name}") }

    Observable.just("C")
            .map { it.length }
            .map { "length is $it" }
            .subscribeOn(Schedulers.computation())
            .subscribe { Log.d("WQY", "anywhere received $it on ${Thread.currentThread().name}") }
}

/**
 * demonstrate 2 points
 *      1): when multiple subscribeOn presents, only the first one (the one closes to source
 *          Observable) will decide which scheduler emission happens on
 *      2): doOnSubscribe() is running on its direct following subscribeOn, if none on calling thread
 * */
private fun tryMultipleSubscribeOn() {
    Observable.range(1, 3)
            .doOnSubscribe {
                Log.d("WQY", "range onSubscribe on ${Thread.currentThread().name}")
            }
            .subscribeOn(Schedulers.newThread())
            .map { "item : $it" }
            .doOnSubscribe {
                Log.d("WQY", "map onSubscribe on ${Thread.currentThread().name}")
            }
            .subscribeOn(Schedulers.computation())
            .filter { it.endsWith("2") }
            .doOnSubscribe {
                Log.d("WQY", "filter onSubscribe on ${Thread.currentThread().name}")
            }
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                Log.d("WQY", "last onSubscribe on ${Thread.currentThread().name}")
            }
            .subscribe {
                Log.d("WQY", "received $it on ${Thread.currentThread().name}")
            }
}

/**
 * demonstrate that subscribeOn has no effect when using with interval, because interval is already
 * working on a different thread
 * */
private fun tryIntervalWithSubScribeOn() {
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
    tryBasicSubscribeOn()
    tryAnyWhereInChain()
    tryMultipleSubscribeOn()

    tryIntervalWithSubScribeOn()
}