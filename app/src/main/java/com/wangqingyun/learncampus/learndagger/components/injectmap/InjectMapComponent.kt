package com.wangqingyun.learncampus.learndagger.components.injectmap

import com.wangqingyun.learncampus.learndagger.DemoInjectBuildersCohort
import com.wangqingyun.learncampus.learndagger.DemoInjectBuildersMap
import com.wangqingyun.learncampus.learndagger.SubComponentBuilder
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * Created by wangqingyun on 23/02/2018.
 */

@Component(modules = arrayOf(InjectMapBinders::class))
interface InjectMapComponent {
    fun inject(injected: DemoInjectBuildersMap)
}

@Module(subcomponents = arrayOf(InjectMapSubComponent::class))
class InjectMapBinders {
    @Provides
    @IntoMap
    @ClassKey(DemoInjectBuildersCohort::class)
    fun provideSubBuilder(builder: InjectMapSubComponent.Builder): SubComponentBuilder<*> = builder
}