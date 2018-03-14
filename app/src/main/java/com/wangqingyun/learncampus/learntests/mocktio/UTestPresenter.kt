package com.wangqingyun.learncampus.learntests.mocktio

import javax.inject.Inject

class UTestPresenter @Inject constructor(
        private val view: UTestContract.View
): UTestContract.Presenter {
    override fun onMeTouched() {
        view.showTouchText("Nice Touch")
    }
}