package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.BiFunction

/**
 * Created by wangqingyun on 28/01/2018.
 */

fun tryZip() {
    Observable.just("Man City", "Chelsea", "Man Utd", "Arsenal", "Liverpool")
            .zipWith<Int, String>(Observable.range(1, 20), BiFunction<String, Int, String> {
                team, rank -> "rank $rank : $team"
            })
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

fun demoZip() {
    tryZip()
}