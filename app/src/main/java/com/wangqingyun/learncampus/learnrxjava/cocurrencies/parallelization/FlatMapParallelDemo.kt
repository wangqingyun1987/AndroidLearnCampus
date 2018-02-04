package com.wangqingyun.learncampus.learnrxjava.cocurrencies.parallelization

import android.util.Log
import com.wangqingyun.learncampus.learnrxjava.cocurrencies.intensiveComputation
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by wangqingyun on 04/02/2018.
 */

private fun tryFlatMapParallel() {
    Observable.range(1, 10)
            .flatMap {
                Observable.just(it)
                        .subscribeOn(Schedulers.computation()) // utilizing cores available
                        .map {
                            intensiveComputation()
                            it
                        }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("WQY", "received $it")
            }
}

private fun tryFlatMapWithGroupBy() {
    val core = Runtime.getRuntime().availableProcessors()
    val count = AtomicInteger()

    Observable.range(1, 15)
            .groupBy {
                count.getAndIncrement() % core
            }
            .flatMap {
                it.observeOn(Schedulers.computation())
                        .map {
                            intensiveComputation()
                            it
                        }
            }
            .subscribe {
                Log.d("WQY", "received $it on ${Thread.currentThread().name}}")
            }
}

fun demoParallelWithFlatMap() {
    tryFlatMapParallel()

    tryFlatMapWithGroupBy()
}