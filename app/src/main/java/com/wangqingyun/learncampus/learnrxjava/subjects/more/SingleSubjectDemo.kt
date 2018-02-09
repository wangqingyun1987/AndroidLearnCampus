package com.wangqingyun.learncampus.learnrxjava.subjects.more

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.SingleSubject
import java.util.concurrent.TimeUnit

/**
 * Created by qingyun.wang on 08/02/2018.
 */

@SuppressLint("LogNotTimber")
private fun trySingleSubject() {
    val singleSubject = SingleSubject.create<Long>()

    singleSubject.subscribe({
        Log.d("WQY", "channel A : $it")
    }, {})

    singleSubject.subscribe({
        Log.d("WQY", "channel SG : $it")
    }, {})

    Observable.interval(100, TimeUnit.MILLISECONDS)
            .take(10)
            .map { it + 1 }
            .reduce { accum: Long, next: Long -> accum + next }
            .toSingle()
            .subscribe(singleSubject)

    Completable.timer(500, TimeUnit.MILLISECONDS)
            .andThen(singleSubject)
            .subscribe({
                Log.d("WQY", "channel PH : $it")
            }, {})

    Completable.timer(1600, TimeUnit.MILLISECONDS)
            .andThen(singleSubject)
            .subscribe({
                Log.d("WQY", "channel VM : $it")
            }, {})
}

fun demoSingleSubject() {
    trySingleSubject()
}