package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 28/01/2018.
 */

fun tryCombineLatest() {
    Observable.combineLatest(
            Function<Array<Any>, String> {
                input ->
                var result = ""
                for (text in input) {
                    when (text) {
                        is String -> result += text + ", "
                    }
                }
                result
            },
            10,
            Observable.interval(300, TimeUnit.MILLISECONDS)
                    .take(10)
                    .map {
                        "A-$it"
                    },
            Observable.interval(500, TimeUnit.MILLISECONDS)
                    .take(5)
                    .map {
                        "B-$it"
                    }
    ).subscribe {
        Log.d("WQY", "combine latest received : $it")
    }
}

fun demoCombineLatest() {
    tryCombineLatest()
}