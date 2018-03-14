package com.wangqingyun.learncampus.learntests.mocktio

import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

@Suppress("ClassName")
class UTestPresenterTest_Mockito {
    @Test
    fun verifyPresenter() {
        val view = Mockito.mock(UTestContract.View::class.java)
        val usecase = com.nhaarman.mockito_kotlin.mock<UTestUsecase>()
        `when`(view.isUIReady()).thenReturn(true)
        val presenter = UTestPresenter(view, usecase)
        presenter.onMeTouched()

        // passing any() here will lead to null error, that is why we will use mockito-kotlin in future
        verify(view, times(1)).showTouchText("Nice Touch")
    }
}