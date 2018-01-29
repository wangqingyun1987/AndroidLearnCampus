package com.wangqingyun.learncampus.learnrxjava.multicast

import android.util.Log
import io.reactivex.Observable
import io.reactivex.observables.ConnectableObservable

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

fun demoConnectableObservable() {
    tryConnectableObservable()
}