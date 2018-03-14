package com.wangqingyun.learncampus.learntests.mocktio

import com.nhaarman.mockito_kotlin.*
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Assert.assertThat

@Suppress("UNUSED_ANONYMOUS_PARAMETER", "ClassName", "FunctionName")
class UTestPresenterTest_MockitoKotlin {
    @Test
    fun verifyUtestPresenter() {
        val view = mock<UTestContract.View>()
        val usecase = mock<UTestUsecase>()
        whenever(view.isUIReady()).thenAnswer { invocation -> true }
        val presenter = UTestPresenter(view, usecase)
        presenter.onMeTouched()
        verify(view, times(1)).showTouchText(any())
    }

    @Test
    fun verifyUtestPresenter_argThat() {
        val view = mock<UTestContract.View>()
        val usecase = mock<UTestUsecase>()
        whenever(view.isUIReady()).thenAnswer { invocation -> true }
        val presenter = UTestPresenter(view, usecase)
        presenter.onMeTouched()
        verify(view).showTouchText(argThat { length == 10 })
    }

    @Test
    fun verifyUtestPresenter_check() {
        val view = mock<UTestContract.View>()
        val usecase = mock<UTestUsecase>()
        whenever(view.isUIReady()).thenAnswer { invocation -> true }
        val presenter = UTestPresenter(view, usecase)
        presenter.onMeTouched()
        verify(view).showTouchText(check {
            assertThat(it.length, `is`(10))
        })
    }

    @Test
    fun verifyUtestPresenter_argumentCaptor() {
        val view = mock<UTestContract.View>()
        val usecase = mock<UTestUsecase>()
        whenever(view.isUIReady()).thenAnswer { invocation -> true }
        val presenter = UTestPresenter(view, usecase)
        presenter.onMeTouched()

        val captor = argumentCaptor<String>()
        verify(view).showTouchText(captor.capture())
        assertEquals(captor.firstValue.length, 10)
    }
}