package com.wangqingyun.learncampus.learntests.mocktio

import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

/**
 * Created by qingyun.wang on 14/03/2018.
 */
class UTestPresenterTest {
    @Test
    fun verifyPresenter() {
        val view = Mockito.mock(UTestContract.View::class.java)
        `when`(view.isUIReady()).thenReturn(true)
        val presenter = UTestPresenter(view)
        presenter.onMeTouched()

        // passing any() here will lead to null error, that is why we will use mockito-kotlin in future
        verify(view, times(1)).showTouchText("Nice Touch")
    }
}