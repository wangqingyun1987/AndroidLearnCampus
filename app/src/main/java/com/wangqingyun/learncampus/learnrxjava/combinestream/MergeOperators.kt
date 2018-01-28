package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable

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

fun tryMergeOperators() {
    tryMerge()
    tryMergeArray()
}