package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables

import android.util.Log
import com.wangqingyun.learncampus.utils.isPrime
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.concurrent.atomic.AtomicInteger

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

/**
 * we can also micromanage our backpressure request in Subscriber
 * */
private fun tryPassingMicroManagedRequest() {
    Flowable.range(100001, 8000)
            .observeOn(Schedulers.computation())
            .filter { it.isPrime() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<Int> {
                lateinit var subscription: Subscription
                val count = AtomicInteger()
                override fun onSubscribe(s: Subscription?) {
                    s?.apply {
                        subscription = s
                        request(40)
                    }
                }

                override fun onNext(t: Int?) {
                    t?.run {
                        Log.d("WQY", "received : $t")
                        if (count.incrementAndGet() % 20 == 0 && count.get() >= 40) {
                            subscription.request(20)
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

fun demoSubscribers() {
    tryPassingLambdas()

    tryPassingMaxLong()

    tryPassingMicroManagedRequest()
}