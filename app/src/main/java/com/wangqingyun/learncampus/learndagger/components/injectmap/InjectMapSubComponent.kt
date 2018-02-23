package com.wangqingyun.learncampus.learndagger.components.injectmap

import com.wangqingyun.learncampus.learndagger.DemoInjectBuildersCohort
import com.wangqingyun.learncampus.learndagger.SubComponentBuilder
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * Created by wangqingyun on 23/02/2018.
 */

@Subcomponent(modules = arrayOf(InjectMapSubModule::class))
interface InjectMapSubComponent {
    @Subcomponent.Builder
    interface Builder: SubComponentBuilder<InjectMapSubComponent>

    fun inject(injected: DemoInjectBuildersCohort)
}

@Module
class InjectMapSubModule {
    @Provides
    fun provideText() = "西匈奴帝国，窝阔台大汗"
}