package com.wangqingyun.learncampus.learntests.mocktio

import javax.inject.Inject

interface UTestUsecase {
    fun recordTouched()
}

class UTestUsecaseImpl @Inject constructor(): UTestUsecase {
    override fun recordTouched() {
        // do nothing
    }
}