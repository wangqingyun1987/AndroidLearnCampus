package com.wangqingyun.learncampus.learndagger.modules.encapsulation

import com.wangqingyun.learncampus.learndagger.models.encapsulation.DataChannel
import com.wangqingyun.learncampus.learndagger.models.encapsulation.DataChannelImpl
import com.wangqingyun.learncampus.learndagger.qualifiers.PrivateToDataChannel
import dagger.Module
import dagger.Provides

/**
 * Created by wangqingyun on 10/01/2018.
 */

@Module
class DataChannelModule {
    @Provides
    @PrivateToDataChannel
    fun provideDataChannel(): DataChannel = DataChannelImpl()
}