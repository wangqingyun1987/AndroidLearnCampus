package com.wangqingyun.learncampus.learntests.mocktio

interface UTestContract {
    interface View {
        fun isUIReady(): Boolean
        fun showTouchText(text: String)
    }

    interface Presenter {
        fun onMeTouched()
    }
}