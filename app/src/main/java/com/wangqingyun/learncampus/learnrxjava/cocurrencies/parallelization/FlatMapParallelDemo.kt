package com.wangqingyun.learncampus.learnrxjava.cocurrencies.parallelization

import android.util.Log
import com.wangqingyun.learncampus.learnrxjava.cocurrencies.intensiveComputation
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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

fun demoParallelWithFlatMap() {
    tryFlatMapParallel()
}