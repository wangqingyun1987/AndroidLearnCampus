package com.wangqingyun.learncampus.learntests.mocktio

interface UTestContract {
    interface View {
        fun showTouchText(text: String)
    }

    interface Presenter {
        fun onMeTouched()
    }
}