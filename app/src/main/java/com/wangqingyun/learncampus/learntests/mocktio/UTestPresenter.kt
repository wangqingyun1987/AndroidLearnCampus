package com.wangqingyun.learncampus.learntests.mocktio

import javax.inject.Inject

class UTestPresenter @Inject constructor(
        private val view: UTestContract.View,
        private val usecase: UTestUsecase
): UTestContract.Presenter {
    override fun onMeTouched() {
        if (view.isUIReady()) {
            usecase.recordTouched()
            view.showTouchText("Nice Touch")
        }
    }
}