package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable

/**
 * Created by wangqingyun on 28/01/2018.
 */

fun tryFlatMapAssociate() {
    Observable.just("Arsenal", "Chelsea", "ManCity")
            .flatMap({
                Observable.fromArray(*it.split("").toTypedArray()).filter { it.isNotEmpty() }
            }, {
                orig, gene -> "$orig-$gene"
            })
            .subscribe {
                Log.d("WQY", "flat map associate : $it")
            }
}

fun tryFlatMapIterable() {
    Observable.just("London", "Madrid", "Moscow")
            .flatMapIterable {
                it.split("")
            }
            .filter { it.isNotEmpty() }
            .subscribe {
                Log.d("WQY", "flatMapIterable : $it")
            }
}

fun tryFlatMap() {
    tryFlatMapAssociate()

    tryFlatMapIterable()
}