package com.wangqingyun.learncampus.learnrxjava.flowcontrol

import android.os.Looper
import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by wangqingyun on 05/02/2018.
 */

private fun tryWindowFixedSize() {
    Observable.range(1, 32)
            .window(10)
            .flatMapSingle<String> {
                it.reduce("") {
                    accum: String, next: Int -> if (accum.isEmpty()) "$next" else "$accum | $next"
                }
            }
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

private fun tryWindowTimeBased() {
    Observable.interval(70, TimeUnit.MILLISECONDS)
            .take(28)
            .window(320, TimeUnit.MILLISECONDS)
            .flatMapSingle<String> {
                it.reduce("") {
                    accum: String, next: Long ->
                    if (accum.isEmpty()) "$next" else "$accum..$next"
                }
            }
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

private fun tryWindowBoundaryObservable() {
    val observable = Observable.create(object: ObservableOnSubscribe<Int> {
        private var count = 0
        private lateinit var emitter: ObservableEmitter<Int>
        private var disposable: Disposable? = null

        private fun run() {
            if (!emitter.isDisposed) {
                disposable = AndroidSchedulers.from(Looper.getMainLooper()).scheduleDirect(
                        {
                            emitter.onNext(++count)
                            run()
                        },
                        200 + Math.abs(Random().nextLong() % 200),
                        TimeUnit.MILLISECONDS
                )
            }
        }

        override fun subscribe(emitter: ObservableEmitter<Int>) {
            this.emitter = emitter

            emitter.setCancellable {
                disposable?.run {
                    if (!isDisposed) {
                        dispose()
                    }
                }
            }

            run()
        }
    })

    Observable.interval(86, TimeUnit.MILLISECONDS)
            .take(30)
            .window(observable)
            .flatMapSingle<String> {
                it.reduce("") {
                    accum: String, next: Long ->
                    if (accum.isEmpty()) "$next" else "$accum + $next"
                }
            }
            .subscribe {
                Log.d("WQY", "received $it")
            }
}

fun demoWindow() {
    tryWindowFixedSize()

    tryWindowTimeBased()

    tryWindowBoundaryObservable()
}