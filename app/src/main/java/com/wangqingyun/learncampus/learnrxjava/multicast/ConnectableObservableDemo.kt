package com.wangqingyun.learncampus.learnrxjava.multicast

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.observables.ConnectableObservable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 29/01/2018.
 */

fun tryConnectableObservable() {
    val observable = Observable.just("Japan", "Korea", "Russia")
    val connectable: ConnectableObservable<String> = observable.publish()

    connectable.subscribe {
        Log.d("WQY", "first subscription : $it")
    }

    connectable.subscribe {
        Log.d("WQY", "second subscription : $it")
    }

    connectable.connect()
}

fun tryAutoConnect() {
    val map = mapOf(
            1 to "Paris",
            2 to "London",
            3 to "Melbourne"
    )

    val connectable = Observable.range(1,3).map { map[it] ?: "None" }.publish()
            .autoConnect(2)

    connectable.map { "Upper stream $it" }.subscribe { Log.d("WQY", "A : $it") }
    connectable.subscribe { Log.d("WQY", "B : $it") }
}

fun tryRefCount() {
    val connectable = Observable.interval(200, TimeUnit.MILLISECONDS).take(3).publish().refCount()

    connectable.subscribe {
        Log.d("WQY", "A : $it")
    }

    Thread(Runnable {
        Thread.sleep(300)
        connectable.subscribe {
            Log.d("WQY", "B : $it")
        }
    }).start()

    Thread(Runnable {
        Thread.sleep(1000)
        connectable.subscribe {
            Log.d("WQY", "C : $it")
        }
    }).start()
}

fun tryShare() {
    val connectable = Observable.interval(100, TimeUnit.MILLISECONDS).take(3).share()

    connectable.subscribe {
        Log.d("WQY", "X : $it")
    }

    Thread(Runnable {
        Thread.sleep(120)
        connectable.subscribe {
            Log.d("WQY", "Y : $it")
        }
    }).start()

    Completable.timer(500, TimeUnit.MILLISECONDS)
            .subscribe {
                connectable.subscribe {
                    Log.d("WQY", "Z : $it")
                }
            }
}

fun demoConnectableObservable() {
    tryConnectableObservable()

    tryAutoConnect()

    tryRefCount()
    tryShare()
}