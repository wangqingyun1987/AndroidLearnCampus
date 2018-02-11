package com.wangqingyun.learncampus.learnrxjava.zxamples.traps

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 11/02/2018.
 */

fun demoWrongEmitterUsage() {
    EmitterWrongUsageDemo().demo()
}

private class EmitterWrongUsageDemo {
    private lateinit var emitter: ObservableEmitter<Int>

    fun demo() {
        val observable = Observable.create<Int> {
            emitter = it
        }

        observable.subscribe {
            Log.d("WQY", "first : $it")
        }

        Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10)
                .subscribe {
                    if (!emitter.isDisposed) {
                        emitter.onNext(it.toInt())
                    }
                }

        Completable.timer(550, TimeUnit.MILLISECONDS)
                .subscribe {
                    observable.subscribe {
                        Log.d("WQY", "second : $it")
                    }
                }
    }
}