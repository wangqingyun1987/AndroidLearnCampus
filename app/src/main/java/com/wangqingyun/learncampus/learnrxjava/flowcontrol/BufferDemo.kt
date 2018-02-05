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

private fun tryBufferFixedSize() {
    Observable.interval(100, TimeUnit.MILLISECONDS)
            .take(32)
            .buffer(5)
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

private fun tryBufferFixedSizeRolling() {
    Observable.range(1, 10)
            .buffer(2, 1)
            .subscribe {
                Log.d("WQY", "received $it")
            }
}

private fun tryBufferTimeBased() {
    Observable.interval(30, TimeUnit.MILLISECONDS)
            .take(30)
            .buffer(100, TimeUnit.MILLISECONDS)
            .subscribe {
                Log.d("WQY", "buffer received $it")
            }
}

private fun tryBufferWithBoundryObservable() {
    val observable = Observable.create(object: ObservableOnSubscribe<Int> {
        private var count = 0
        private lateinit var emitter: ObservableEmitter<Int>
        private var stopped = AtomicBoolean(false)
        private var disposable: Disposable? = null
        private fun run() {
            if (!stopped.get()) {
                disposable = AndroidSchedulers.from(Looper.getMainLooper()).scheduleDirect(
                        {
                            emitter.onNext(++count)
                            run()
                        },
                        (200 + Math.abs(Random().nextInt() % 200)).toLong(),
                        TimeUnit.MILLISECONDS
                )
            }
        }
        override fun subscribe(emitter: ObservableEmitter<Int>) {
            this.emitter = emitter
            emitter.setCancellable {
                Log.d("WQY", "emitter is canceled")
                stopped.set(true)
                disposable?.run {
                    if (!isDisposed) {
                        dispose()
                    }
                }
            }
            run()
        }
    })

    Observable.interval(150, TimeUnit.MILLISECONDS)
            .take(20)
            .doOnComplete {
                Log.d("WQY", "complete before buffer")
            }
            .buffer(observable)
            .doOnComplete {
                Log.d("WQY", "complete after buffer")
            }
            .subscribe {
                Log.d("WQY", "received $it")
            }
}

fun demoBuffer() {
    tryBufferFixedSize()
    tryBufferFixedSizeRolling()

    tryBufferTimeBased()

    tryBufferWithBoundryObservable()
}