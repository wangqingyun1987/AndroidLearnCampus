package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

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

/**
 * what flatMapIterable actually does is it turns each emission from source observable into an iterable,
 * and then pass each item of the iterable down the stream
 * */
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

fun tryFlatMapSingle() {
    Observable.just("Beijing", "Shenzhen", "Chengdu")
            .flatMapSingle {
                seq -> Single.just("A").map { "$it-$seq-$it" }
            }
            .subscribe {
                Log.d("WQY", "flat map single : $it")
            }
}

fun tryFlatMapComplatable() {
    Observable.just("Football", "Tennis", "Cricket")
            .map { 0 }
            .scan { count: Int, next: Int -> count + 1 }
            .flatMapCompletable {
                Completable.timer((it + 1).toLong(), TimeUnit.SECONDS)
            }
            .subscribe {
                Log.d("WQY", "completed")
            }
}

fun tryFlatMap() {
    tryFlatMapAssociate()

    tryFlatMapIterable()

    tryFlatMapSingle()

    tryFlatMapComplatable()
}