package com.wangqingyun.learncampus.learnrxjava.cocurrencies

import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 02/02/2018.
 *
 * This is a collection of demos for bad usages of concurrency in RxJava
 */

/**
 * because we flatmap each item to an interval(), each of which will be scheduled onto computation() thread pool,
 *      but at the same time second observable observeOn computation() as well (i.e. having its runnables
 *      posted onto computation() thread pool), then this could happen:
 *          interval() task posted on to computation() for "B" can be the on same thread currently waiting in map(which is sleeping),
 *          so "C" can actually be emitted prio to "B", so result can be unexpected
 *      to solve this, we can observeOn(Schedulers.from(Executors.newSingleThreadPool()) at end of obA and obB
 * */
fun tryZipMultipleThreadedStreams() {
    val obA = Observable.just("A", "B", "C", "D", "E")
            .flatMap(object: Function<String, Observable<String>> {
                var count = 0
                override fun apply(t: String): Observable<String> {
                    return Observable.interval((++count * 1000).toLong(), TimeUnit.MILLISECONDS).take(1).map { t }
                }
            })
            .observeOn(Schedulers.io())
//            .observeOn(Schedulers.from(Executors.newSingleThreadExecutor()))

    val obB = Observable.range(1, 5)
            .flatMap(object: Function<Int, Observable<Int>> {
                var count = 0
                override fun apply(t: Int): Observable<Int> =
                        Observable.interval((++count * 1200).toLong(), TimeUnit.MILLISECONDS).take(1).map { t }
            })
            .observeOn(Schedulers.computation())
//            .observeOn(Schedulers.from(Executors.newSingleThreadExecutor()))

    Observable.zip(obA, obB, BiFunction { a: String, b: Int -> "$a - $b" })
            .map(object: Function<String, String> {
                var count = 0
                override fun apply(t: String): String {
                    if (count++ % 2 == 0) Thread.sleep(2000)
                    return t
                }
            })
            .subscribe {
                Log.d("WQY", "received $it on ${Thread.currentThread().id}")
            }
}

fun demoBadConcurrencySamples() {
    tryZipMultipleThreadedStreams()
}