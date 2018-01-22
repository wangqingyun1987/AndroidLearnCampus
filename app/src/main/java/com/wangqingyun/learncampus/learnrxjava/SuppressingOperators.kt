package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable

/**
 * Created by wangqingyun on 22/01/2018.
 */

fun tryFilter() {
    Observable.range(10, 10)
            .filter { it % 2 == 0 }
            .subscribe { Log.d("WQY", "even number : $it") }
}

fun trySuppressing() {
    tryFilter()
}