package com.wangqingyun.learncampus.learndagger.components

import com.wangqingyun.learncampus.learndagger.SubComponentBuilder
import com.wangqingyun.learncampus.learndagger.modules.HumanModule
import dagger.Component

/**
 * Created by wangqingyun on 09/01/2018.
 */

@Component(modules = arrayOf(HumanModule::class))
interface HumanComponent {
    fun getBuildsMap(): Map<Class<*>, SubComponentBuilder<*>>
}