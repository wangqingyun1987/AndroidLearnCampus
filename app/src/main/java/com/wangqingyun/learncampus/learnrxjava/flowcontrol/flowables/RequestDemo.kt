package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Created by wangqingyun on 08/02/2018.
 */

private fun tryNoRequest() {
    Flowable.range(1, 6)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<Int> {
                override fun onSubscribe(s: Subscription?) {
                    s?.run {
                        Log.d("WQY", "onSubscribe")
                    }
                }

                override fun onNext(t: Int?) {
                    t?.run {
                        Log.d("WQY", "received : $this")
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

private fun tryRequest2() {
    Flowable.range(1, 6)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<Int> {
                override fun onSubscribe(s: Subscription?) {
                    s?.run {
                        Log.d("WQY", "onSubscribe")
                        request(2)
                    }
                }

                override fun onNext(t: Int?) {
                    t?.run {
                        Log.d("WQY", "received : $this")
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

private fun tryRequestAll() {
    Flowable.range(1, 6)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<Int> {
                override fun onSubscribe(s: Subscription?) {
                    s?.run {
                        Log.d("WQY", "onSubscribe")
                        request(Long.MAX_VALUE)
                    }
                }

                override fun onNext(t: Int?) {
                    t?.run {
                        Log.d("WQY", "received : $this")
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

fun demoFlowableRequest() {
    tryNoRequest()

    tryRequest2()

    tryRequestAll()
}