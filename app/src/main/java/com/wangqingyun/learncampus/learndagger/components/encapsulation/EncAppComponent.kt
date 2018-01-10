package com.wangqingyun.learncampus.learndagger.components.encapsulation

import com.wangqingyun.learncampus.learndagger.modules.encapsulation.EncAppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wangqingyun on 10/01/2018.
 */

@Singleton
@Component(modules = arrayOf(EncAppModule::class))
interface EncAppComponent {
    fun uiBuilder(): EncUIComponnet.Builder
}