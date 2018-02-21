package com.wangqingyun.learncampus.learnrxjava.test.nonblocking

import io.reactivex.observers.TestObserver
import org.junit.Assert.*
import org.junit.Test

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
}