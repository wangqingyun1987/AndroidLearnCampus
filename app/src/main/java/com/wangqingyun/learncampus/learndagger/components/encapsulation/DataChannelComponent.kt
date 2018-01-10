package com.wangqingyun.learncampus.learndagger.components.encapsulation

import com.wangqingyun.learncampus.learndagger.models.encapsulation.DataChannel
import com.wangqingyun.learncampus.learndagger.modules.encapsulation.DataChannelModule
import com.wangqingyun.learncampus.learndagger.qualifiers.PrivateToDataChannel
import dagger.Subcomponent

/**
 * Created by wangqingyun on 10/01/2018.
 */

@Subcomponent(modules = arrayOf(DataChannelModule::class))
interface DataChannelComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): DataChannelComponent
    }

    @PrivateToDataChannel
    fun getDataChannel(): DataChannel
}