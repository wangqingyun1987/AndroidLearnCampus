package com.wangqingyun.learncampus.learnrxjava.transformers

import android.os.Looper
import android.util.Log
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by wangqingyun on 10/02/2018.
 */

private fun tryCompose() {
    fun <T> asyncCall(): ObservableTransformer<T, T> = ObservableTransformer {
        upstream ->
        upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    Observable.create<Int>(object: ObservableOnSubscribe<Int> {
        var count = AtomicInteger()
        lateinit var emitter: Emitter<Int>
        private fun run() {
            if (count.incrementAndGet() > 10) {
                emitter.onComplete()
            } else {
                emitter.onNext(count.get())
            }

            AndroidSchedulers.from(Looper.getMainLooper()).scheduleDirect({ run() }, 100, TimeUnit.MILLISECONDS)
        }

        override fun subscribe(emitter: ObservableEmitter<Int>) {
            this.emitter = emitter
            Log.d("WQY", "start on : ${Thread.currentThread().name}")
            run()
        }
    })
            .compose(asyncCall())
            .subscribe {
                Log.d("WQY", "received $it on ${Thread.currentThread().name}")
            }
}

fun demoObservableTransform() {
    tryCompose()
}