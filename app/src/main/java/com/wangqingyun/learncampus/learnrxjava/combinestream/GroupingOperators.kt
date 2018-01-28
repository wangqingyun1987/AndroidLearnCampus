package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.BiFunction

/**
 * Created by wangqingyun on 28/01/2018.
 */

fun tryGroupBy() {
    Observable.just("Paris", "London", "Munich", "Milan", "Rome", "Moscow")
            .groupBy {
                it.length
            }
            .flatMapSingle {
                it.toList()
            }
            .subscribe {
                Log.d("WQY", "groupBy received : $it")
            }

    Observable.just("Arsenal", "Barcelona", "Juventus", "Chelsea", "ManCity")
            .groupBy { it.length }
            .flatMapSingle {
                grouped -> grouped.reduce("", BiFunction { t1, t2 -> if (t1.isEmpty()) t2 else "$t1, $t2" })
                        .map { "${grouped.key}: $it" }
            }
            .subscribe {
                Log.d("WQY", "teams received : $it")
            }
}

fun demoGrouping() {
    tryGroupBy()
}