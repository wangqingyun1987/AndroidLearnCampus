package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 28/01/2018.
 */

fun tryMerge() {
    Observable.merge(
            Observable.just("Zidanei", "Backham", "Ronaldo"),
            Observable.just("Ronaldinho", "Vanni")
    ).subscribe {
        Log.d("WQY", "merge factory : $it")
    }

    Observable.merge(
            Observable.interval(500, TimeUnit.MILLISECONDS)
                    .map { "A-$it" }
                    .take(3),
            Observable.interval(200, TimeUnit.MILLISECONDS)
                    .map { "B-$it" }
                    .take(5)
    ).subscribe {
        Log.d("WQY", "merged with interval : $it")
    }

    Observable.just("London", "Manchester", "Birmingham")
            .mergeWith(
                    Observable.just("Berlin", "Hamburg", "Munich")
            )
            .subscribe {
                Log.d("WQY", "merge with : $it")
            }
}

fun tryMergeArray() {
    val array = arrayOf(
            Observable.just("BJ", "SZ"),
            Observable.just("SG", "KL"),
            Observable.just("Sydney", "Melbourne"),
            Observable.just("New York", "LA"),
            Observable.just("Paris", "Berlin")
    )

    Observable.mergeArray(*array)
            .subscribe {
                Log.d("WQY", "city array : $it")
            }
}

fun tryMergeIterable() {
    val list = listOf<Observable<String>>(
            Observable.just("A", "B"),
            Observable.just("1", "101"),
            Observable.just("donkey", "horse")
    )

    Observable.merge(list)
            .subscribe {
                Log.d("WQY", "merge iterable : $it")
            }
}

fun tryMergeOperators() {
    tryMerge()
    tryMergeArray()

    tryMergeIterable()
}