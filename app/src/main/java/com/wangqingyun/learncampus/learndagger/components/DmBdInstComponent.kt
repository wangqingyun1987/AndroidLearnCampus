package com.wangqingyun.learncampus.learndagger.components

import com.wangqingyun.learncampus.learndagger.DemoBindsInstance
import com.wangqingyun.learncampus.learndagger.modules.DmBdsInstModule
import dagger.BindsInstance
import dagger.Component

/**
 * Created by wangqingyun on 22/02/2018.
 */

@Component(modules = arrayOf(DmBdsInstModule::class))
interface DmBdInstComponent {
    @Component.Builder
    interface Builder {
        fun build(): DmBdInstComponent

        @BindsInstance fun nameSource(nameSource: () -> String): Builder
    }

    fun inject(instance: DemoBindsInstance)
}