package com.wangqingyun.learncampus.learnrxjava.cocurrencies

import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 03/02/2018.
 */

fun tryComputation() {
    Observable.just("A", "B")
            .subscribeOn(Schedulers.computation())
            .subscribe { Log.d("WQY", "computation received $it on ${Thread.currentThread().id}") }
}

fun tryIo() {
    Observable.range(1, 5)
            .flatMap {
                Observable.just(it).subscribeOn(Schedulers.io())
            }
            .subscribe {
                Log.d("WQY", "io received $it on ${Thread.currentThread().id}")
            }
}

fun tryNewThread() {
    Observable.range(1, 3)
            .concatMap {
                Observable.just(it).subscribeOn(Schedulers.newThread())
            }
            .subscribe {
                Log.d("WQY", "newThread received $it on ${Thread.currentThread().id}")
            }
}

fun trySingle() {
    Observable.just("King", "Soldier")
            .subscribeOn(Schedulers.single())
            .subscribe {
                Log.d("WQY", "single received $it on ${Thread.currentThread().id}")
            }
}

fun tryTrampoline() {
    Log.d("WQY", "start trampoline on ${Thread.currentThread().id}")
    Observable.just("Germany", "Britain", "France")
            .subscribeOn(Schedulers.trampoline())
            .subscribe {
                Log.d("WQY", "trampoline received : $it on ${Thread.currentThread().id}")
            }
    Log.d("WQY", "end trampoline on ${Thread.currentThread().id}")
}

fun tryFromExecutorService() {
    val executor = Executors.newFixedThreadPool(10)
    Observable.interval(100, TimeUnit.MILLISECONDS).take(5)
            .observeOn(Schedulers.from(executor))
            .doFinally {
                Log.d("WQY", "need to dispose executor")
                executor.shutdown()
            }
            .subscribe({
                Log.d("WQY", "from executor received : $it on ${Thread.currentThread().id}")
            }, {}, {
                Log.d("WQY", "from executor complete")
            })
}

fun demoSchedulers() {
    tryComputation()
    tryIo()
    tryNewThread()
    trySingle()

    tryTrampoline()

    tryFromExecutorService()
}