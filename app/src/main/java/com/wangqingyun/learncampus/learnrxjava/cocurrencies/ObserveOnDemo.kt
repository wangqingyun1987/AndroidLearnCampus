package com.wangqingyun.learncampus.learnrxjava.cocurrencies

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by wangqingyun on 04/02/2018.
 */

private fun tryBasicObserveOn() {
    Observable.just("Apple")
            .subscribeOn(Schedulers.io())
            .doOnNext {
                Log.d("WQY", "after data on ${Thread.currentThread().name}")
            }
            .observeOn(Schedulers.computation())
            .map {
                // mimic calculation
                it
            }
            .doOnNext {
                Log.d("WQY", "after calculation on ${Thread.currentThread().name}")
            }
            .observeOn(Schedulers.io())
            .map {
                // mimic writing data back to storage
                it
            }
            .doOnNext {
                Log.d("WQY", "after writing back data on ${Thread.currentThread().name}")
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("WQY", "received $it on ${Thread.currentThread().name}")
            }
}

fun demoObserveOn() {
    tryBasicObserveOn()
}