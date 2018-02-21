package com.wangqingyun.learncampus.learnrxjava.test.nonblocking

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Assert.*
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 21/02/2018.
 */
class TenElementsKtTest {
    @Test
    fun verifyTen() {
        val source = getTenElements()

        val observer = TestObserver<Long>()

        observer.assertNotSubscribed()

        source.subscribe(observer)

        observer.assertSubscribed()

        observer.awaitTerminalEvent()

        observer.assertComplete()

        observer.assertNoErrors()

        observer.assertValueCount(10)

        observer.assertValues(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

    @Test
    fun verifyOneSecond() {
        val source = getTenElements()
        val observer = TestObserver<Long>()

        source.subscribe(observer)

        observer.assertSubscribed().awaitTerminalEvent(1200, TimeUnit.MILLISECONDS)

        observer.assertComplete()
                .assertNoErrors()
                .assertValueCount(10)
    }

    @Test
    fun verifyWithCount() {
        val source = Observable.interval(100, TimeUnit.MILLISECONDS).take(1000)
        val observer = TestObserver<Long>()

        source.subscribe(observer)

        observer.awaitCount(5)
                .assertNotComplete()
                .assertNoErrors()
                .assertValueCount(5)
    }
}