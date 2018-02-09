package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables

import android.util.Log
import io.reactivex.BackpressureStrategy
import io.reactivex.FlowableSubscriber
import io.reactivex.Observable
import org.reactivestreams.Subscription

/**
 * Created by wangqingyun on 09/02/2018.
 */

private fun tryWithStrategyError() {
    val source = Observable.range(1, 10000)

    source.toFlowable(BackpressureStrategy.ERROR)
            .subscribe(object : FlowableSubscriber<Int> {
                override fun onSubscribe(s: Subscription) {
                    s.request(100)
                }

                override fun onNext(t: Int?) {
                    t?.run { Log.d("WQY", "received prime : $this") }
                }

                override fun onError(t: Throwable?) {
                    t?.run { Log.d("WQY", "error : ${this.message}") }
                }

                override fun onComplete() {
                    Log.d("WQY", "complete")
                }
            })
}

fun demoObservableToFlowable() {
    tryWithStrategyError()
}