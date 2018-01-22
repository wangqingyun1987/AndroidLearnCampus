package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter

/**
 * Created by wangqingyun on 22/01/2018.
 */

fun tryCreate() {
    var emitter: ObservableEmitter<Int>? = null
    val observable = Observable.create<Int> {
        emitter = it
        emitter?.setCancellable { Log.d("WQY", "remove resources upon disposal") }
    }

    observable.take(2)
            .subscribe { Log.d("WQY", "first two element : $it") }

    emitter?.onNext(3)
    emitter?.onNext(7)
    emitter?.onNext(11)
    emitter?.onNext(13)
    emitter?.onNext(17)
}

fun tryCreateOperators() {
    tryCreate()
}