package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables

import android.util.Log
import com.wangqingyun.learncampus.utils.isPrime
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Created by wangqingyun on 08/02/2018.
 */

/**
 * the easiest way of constructing a subscriber would be using lambdas
 * */
private fun tryPassingLambdas() {
    Flowable.range(1, 100000)
            .observeOn(Schedulers.computation())
            .filter { it.isPrime() && it > 2000 && it < 5000 }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("WQY", "prime number : $it")
            }
}

/**
 * we cal also construct Subscriber by implementing it, but we have to call request() to signal
 * to upstream size of batch, the simplest way is to pass Long.MAX_VALUE
 * */
private fun tryPassingMaxLong() {
    Flowable.range(10001, 10000)
            .observeOn(Schedulers.computation())
            .filter { it.isPrime() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: Subscriber<Int> {
                override fun onSubscribe(s: Subscription?) {
                    s?.request(Long.MAX_VALUE)
                }

                override fun onError(t: Throwable?) {
                    t?.printStackTrace()
                }

                override fun onNext(t: Int?) {
                    t?.run {
                        Log.d("WQY", "received : $this")
                    }
                }

                override fun onComplete() {
                    Log.d("WQY", "complete")
                }
            })
}

fun demoSubscribers() {
    tryPassingLambdas()

    tryPassingMaxLong()
}