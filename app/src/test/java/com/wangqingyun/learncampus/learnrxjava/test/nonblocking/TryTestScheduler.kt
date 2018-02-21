package com.wangqingyun.learncampus.learnrxjava.test.nonblocking

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.TestScheduler
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 21/02/2018.
 */

class TryTestScheduler {
    @Test
    fun verify90Emissions() {
        val scheduler = TestScheduler()
        val source    = Observable.interval(1, TimeUnit.MINUTES, scheduler).take(90)
        val observer  = TestObserver<Long>()

        source.subscribe(observer)

        scheduler.advanceTimeBy(50, TimeUnit.SECONDS)

        observer.assertNoValues()

        scheduler.advanceTimeBy(50, TimeUnit.SECONDS)

        observer.assertValueCount(1)

        scheduler.advanceTimeBy(100, TimeUnit.MINUTES)

        observer.assertComplete()
                .assertNoErrors()
                .assertValueCount(90)
    }

    @Test
    fun verifyTenElements() {
        val scheduler = TestScheduler()
        RxJavaPlugins.setComputationSchedulerHandler { scheduler }

        val source = getTenElements()
        val observer = TestObserver<Long>()

        source.subscribe(observer)

        scheduler.advanceTimeBy(2, TimeUnit.SECONDS)

        observer.assertComplete()
                .assertNoErrors()
                .assertValueCount(10)
    }
}