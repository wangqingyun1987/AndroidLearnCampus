package com.wangqingyun.learncampus.learndagger.modules

import com.wangqingyun.learncampus.learndagger.OneDagger
import com.wangqingyun.learncampus.learndagger.SubComponentBuilder
import com.wangqingyun.learncampus.learndagger.components.AnimalComponent
import com.wangqingyun.learncampus.learndagger.models.Staff
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * Created by wangqingyun on 09/01/2018.
 */

@Module(subcomponents = arrayOf(AnimalComponent::class))
class HumanModule {
    @Provides
    fun provideStaffMike() = Staff("Mike", 36)

    @Provides
    @IntoMap
    @ClassKey(OneDagger::class)
    fun provideOneDagger(builder: AnimalComponent.Builder): SubComponentBuilder<*> = builder
}