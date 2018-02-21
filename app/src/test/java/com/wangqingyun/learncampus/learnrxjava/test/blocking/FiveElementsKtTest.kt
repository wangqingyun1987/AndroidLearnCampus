package com.wangqingyun.learncampus.learnrxjava.test.blocking

import org.junit.Assert.*
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by wangqingyun on 21/02/2018.
 */
class FiveElementsKtTest {
    @Test
    fun verifyFive() {
        val hitCount = AtomicInteger(0)

        getFiveElements().blockingSubscribe {
            hitCount.incrementAndGet()
        }

        assertEquals(hitCount.get(), 5)
    }
}