package com.wangqingyun.learncampus.learnrxjava.cocurrencies

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 02/02/2018.
 */

fun tryBlockingSUbscribe() {
    Observable.range(1, 5)
            .flatMap(object: Function<Int, Observable<Int>> {
                var count = 1
                override fun apply(t: Int): Observable<Int> {
                    return Completable.timer((count++ * 100).toLong(), TimeUnit.MILLISECONDS).andThen(
                            Observable.just(t)
                    )
                }
            })
            .blockingSubscribe {
                Log.d("WQY", "received : $it")
            }

    Log.d("WQY", "receive done")
}

fun demoConcurrenyOperators() {
    tryBlockingSUbscribe()
}