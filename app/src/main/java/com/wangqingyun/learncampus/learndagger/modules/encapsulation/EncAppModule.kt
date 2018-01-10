package com.wangqingyun.learncampus.learndagger.modules.encapsulation

import com.wangqingyun.learncampus.learndagger.components.encapsulation.DataChannelComponent
import com.wangqingyun.learncampus.learndagger.components.encapsulation.EncUIComponnet
import com.wangqingyun.learncampus.learndagger.models.encapsulation.DataChannel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by wangqingyun on 10/01/2018.
 */

@Module(subcomponents = arrayOf(DataChannelComponent::class, EncUIComponnet::class))
class EncAppModule {
    @Singleton
    @Provides
    fun provideDataChannel(builder: DataChannelComponent.Builder): DataChannel = builder.build().getDataChannel()
}