package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables

import android.util.Log
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import org.reactivestreams.Subscription

/**
 * Created by wangqingyun on 09/02/2018.
 */

/**
 * request(n) is ignored
 * */
private fun tryCreateWithMissing() {
    Flowable.create<Int>(
            { emitter ->
                for (q in 1..30) {
                    if (!emitter.isCancelled) {
                        emitter.onNext(q)
                    }
                }
                emitter.onComplete()
            },
            BackpressureStrategy.MISSING
    ).subscribe(object : FlowableSubscriber<Int> {
        override fun onComplete() {
            Log.d("WQY", "onComplete")
        }

        override fun onNext(t: Int?) {
            t?.run { Log.d("WQY", "received : $this") }
        }

        override fun onSubscribe(s: Subscription) {
            s.request(6)
        }

        override fun onError(t: Throwable?) {
            t?.run { Log.d("WQY", "error : ${this.message}") }
        }
    })
}

private fun tryCreateWithLatest() {
    Flowable.create<Int>(
            { emitter ->
                for (q in 1..20) {
                    if (!emitter.isCancelled) {
                        emitter.onNext(q)
                    }
                }
                emitter.onComplete()
            },
            BackpressureStrategy.LATEST
    ).subscribe(object : FlowableSubscriber<Int> {
        override fun onError(t: Throwable?) {
            t?.printStackTrace()
        }

        override fun onComplete() {
            Log.d("WQY", "on complete")
        }

        override fun onNext(t: Int?) {
            t?.run { Log.d("WQY", "received : $this") }
        }

        override fun onSubscribe(s: Subscription) {
            s.request(5)
        }
    })
}

fun demoFlowableCreate() {
    tryCreateWithMissing()

    tryCreateWithLatest()
}