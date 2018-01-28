package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 28/01/2018.
 */

fun tryConcatMap() {
    Observable.just(100, 10, 30, 120)
            .concatMap {
                del -> Observable.interval(del.toLong(), TimeUnit.MILLISECONDS).take(1)
                    .map { del }
            }
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

/**
 * difference between concatMap and concatMapEager
 *  concatMap:      subscribe to one observable and wait it to finish and then subscribe to next
 *  concatMapEager: subscribe to all observables and put their emission into cache and pass down
 *                  emissions from observables one observable after another
 * */
fun tryConcatMapEager() {
    Observable.just(100, 10, 30, 120)
            .concatMapEager {
                del ->
                Observable.create<Int> {
                    Log.d("WQY", "concatMapEager subscribed : $del")
                    Thread.sleep(del.toLong())
                    it.onNext(del)
                    it.onComplete()
                }.subscribeOn(Schedulers.from(Executors.newSingleThreadExecutor()))
            }
            .subscribe { Log.d("WQY", "concatMapEager received : $it") }
}

fun tryConcatMapDemo() {
    tryConcatMap()

    tryConcatMapEager()
}