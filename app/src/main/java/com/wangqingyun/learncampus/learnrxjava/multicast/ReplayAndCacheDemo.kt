package com.wangqingyun.learncampus.learnrxjava.multicast

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.observables.ConnectableObservable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 29/01/2018.
 */

fun tryReplay() {
    val connectable: ConnectableObservable<Long> = Observable.interval(100, TimeUnit.MILLISECONDS)
            .take(10)
            .replay()

    val source = connectable.autoConnect()

    source.subscribe {
        Log.d("WQY", "Uppper : $it")
    }

    Completable.timer(500, TimeUnit.MILLISECONDS)
            .andThen(source)
            .subscribe {
                Log.d("WQY", "Lower : $it")
            }
}

fun demoReplayAndCache() {
    tryReplay()
}