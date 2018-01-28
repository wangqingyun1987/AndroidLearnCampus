package com.wangqingyun.learncampus.learnrxjava.combinestream

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 28/01/2018.
 */

fun tryAmb() {
    Observable.amb(listOf(
            Observable.interval(600L, TimeUnit.MILLISECONDS)
                    .take(3)
                    .map { "A-$it" },
            Observable.interval(450L, TimeUnit.MILLISECONDS)
                    .take(3)
                    .map { "B-$it" }
    )).subscribe {
        Log.d("WQY", "amb received : $it")
    }
}

fun tryAmbiguous() {
    tryAmb()
}