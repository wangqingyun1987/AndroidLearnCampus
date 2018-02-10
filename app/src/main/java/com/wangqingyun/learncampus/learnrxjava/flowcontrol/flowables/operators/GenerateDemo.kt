package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables.operators

import android.util.Log
import com.wangqingyun.learncampus.utils.nextPrime
import io.reactivex.Emitter
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription
import java.util.concurrent.Callable
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by wangqingyun on 10/02/2018.
 */

private fun tryGenerate() {
    Flowable.generate<Int>(object : Consumer<Emitter<Int>> {
        private var number = 0
        override fun accept(emitter: Emitter<Int>?) {
            emitter?.run {
                number = number.nextPrime()
                Log.d("WQY", "emitter emit $number on ${Thread.currentThread().name}")
                onNext(number)
            }
        }
    })
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: FlowableSubscriber<Int> {
                private var count = 0
                private lateinit var subscription: Subscription
                override fun onSubscribe(s: Subscription) {
                    subscription = s
                    subscription.request(5)
                }

                override fun onNext(t: Int?) {
                    t?.run {
                        Log.d("WQY", "received : $this on ${Thread.currentThread().name}")
                        if (++count == 5) {
                            subscription.request(5)
                        }
                    }
                }

                override fun onError(t: Throwable?) {
                    t?.printStackTrace()
                }

                override fun onComplete() {
                    Log.d("WQY", "complete")
                }
            })
}

private fun tryWithState() {
    Flowable.generate<Int, AtomicInteger>(
            Callable {
                AtomicInteger(0)
            },
            BiFunction {
                state, emitter ->
                val nextPrime = state.get().nextPrime()
                state.set(nextPrime)
                if (nextPrime > 100) {
                    emitter.onComplete()
                } else {
                    emitter.onNext(nextPrime)
                }
                state
            }
    )
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: FlowableSubscriber<Int> {
                override fun onSubscribe(s: Subscription) {
                    s.request(Long.MAX_VALUE)
                }

                override fun onNext(t: Int?) {
                    t?.run { Log.d("WQY", "received : $this") }
                }

                override fun onError(t: Throwable?) {
                    t?.run { Log.d("WQY", "error : ${this.message}") }
                }

                override fun onComplete() {
                    Log.d("WQY", "complete")
                }
            })
}

fun demoFlowableGenerate() {
    tryGenerate()

    tryWithState()
}