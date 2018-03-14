package com.wangqingyun.learncampus.learntests.mocktio

import com.nhaarman.mockito_kotlin.*
import org.junit.Test

@Suppress("UNUSED_ANONYMOUS_PARAMETER", "ClassName")
class UTestPresenterTest_MockitoKotlin {
    @Test
    fun verifyUtestPresenter() {
        val view = mock<UTestContract.View>()
        whenever(view.isUIReady()).thenAnswer { invocation -> true }
        val presenter = UTestPresenter(view)
        presenter.onMeTouched()
        verify(view, times(1)).showTouchText(any())
    }
}