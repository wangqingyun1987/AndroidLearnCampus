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

fun tryReplayWithBufferSize() {
    val connectable: ConnectableObservable<Long> = Observable.interval(100, TimeUnit.MILLISECONDS)
            .take(10)
            .replay(2)

    val source = connectable.autoConnect()

    source.subscribe {
        Log.d("WQY", "A: $it")
    }

    Completable.timer(600, TimeUnit.MILLISECONDS)
            .andThen(source)
            .subscribe {
                Log.d("WQY", "B: $it")
            }
}

fun tryReplayWithConnectAndRefCount() {
    val sourceAuto = Observable.range(1, 3).replay(1).autoConnect()

    sourceAuto.subscribe {
        Log.d("WQY", "Auto A : $it")
    }

    sourceAuto.subscribe {
        Log.d("WQY", "Auto B : $it")
    }

    val sourceRef = Observable.range(100, 3).replay(1).refCount()

    sourceRef.subscribe {
        Log.d("WQY", "Ref A : $it")
    }

    sourceRef.subscribe {
        Log.d("WQY", "Ref B : $it")
    }
}

fun demoReplayAndCache() {
    tryReplay()
    tryReplayWithBufferSize()

    tryReplayWithConnectAndRefCount()
}