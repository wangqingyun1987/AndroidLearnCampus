package com.wangqingyun.learncampus.learndagger.components.encapsulation

import com.wangqingyun.learncampus.learndagger.DaggerEncapsulate
import com.wangqingyun.learncampus.learndagger.SubEncapsulate
import com.wangqingyun.learncampus.learndagger.modules.encapsulation.EncUIModule
import com.wangqingyun.learncampus.learndagger.scopes.EncUIScope
import dagger.Subcomponent

/**
 * Created by wangqingyun on 10/01/2018.
 */

@EncUIScope
@Subcomponent(modules = arrayOf(EncUIModule::class))
interface EncUIComponnet {
    @Subcomponent.Builder
    interface Builder {
        fun build(): EncUIComponnet
    }

    fun inject(instance: DaggerEncapsulate)
    fun inject(instance: SubEncapsulate)
}