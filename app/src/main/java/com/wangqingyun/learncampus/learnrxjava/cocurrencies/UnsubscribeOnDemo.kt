package com.wangqingyun.learncampus.learnrxjava.cocurrencies

import android.os.Looper
import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 05/02/2018.
 */

private fun tryUnsubscribeOn() {
    val disposable = Observable.create<Int>(object: ObservableOnSubscribe<Int> {
        private var count = 0
        override fun subscribe(emitter: ObservableEmitter<Int>) {
            val disposable = AndroidSchedulers.from(Looper.getMainLooper())
                    .schedulePeriodicallyDirect({
                        emitter.onNext(++count)
                    }, 0, 1000, TimeUnit.MILLISECONDS)
            emitter.setCancellable {
                Log.d("WQY", "emitter disposed on ${Thread.currentThread().name}")
                disposable.dispose()
            }
        }
    })
            .unsubscribeOn(Schedulers.single())
            .doOnDispose {
                Log.d("WQY", "above filter dispose on ${Thread.currentThread().name}")
            }
            .filter { it % 3 == 0 }
            .unsubscribeOn(Schedulers.newThread())
            .doOnDispose {
                Log.d("WQY", "above map dispose on ${Thread.currentThread().name}")
            }
            .map { "item $it" }
            .unsubscribeOn(Schedulers.io())
            .doOnDispose {
                Log.d("WQY", "above subscribe dispose on ${Thread.currentThread().name}")
            }
            .subscribe {
                Log.d("WQY", "received $it")
            }

    Completable.timer(5500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                disposable.dispose()
            }
}

fun demoUnsubscribeOn() {
    tryUnsubscribeOn()
}