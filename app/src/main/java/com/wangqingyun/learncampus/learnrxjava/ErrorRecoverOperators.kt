package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable

/**
 * Created by wangqingyun on 24/01/2018.
 */

fun tryErrorCondition() {
    Observable.just(3, 2, 1, 0, 4, 5)
            .map { 100 / it }
            .subscribe({
                Log.d("WQY", "received : $it")
            }, {
                Log.d("WQY", "error : ${it.message}")
            })
}

fun tryErrorRecoverOperators() {
    tryErrorCondition()
}