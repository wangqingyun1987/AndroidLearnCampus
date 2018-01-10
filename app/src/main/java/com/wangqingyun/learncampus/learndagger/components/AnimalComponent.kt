package com.wangqingyun.learncampus.learndagger.components

import com.wangqingyun.learncampus.learndagger.OneDagger
import com.wangqingyun.learncampus.learndagger.SubComponentBuilder
import com.wangqingyun.learncampus.learndagger.modules.AnimalModule
import com.wangqingyun.learncampus.learndagger.modules.BirdModule
import dagger.Subcomponent

/**
 * Created by wangqingyun on 09/01/2018.
 */

@Subcomponent(modules = arrayOf(AnimalModule::class, BirdModule::class))
interface AnimalComponent {
    @Subcomponent.Builder
    interface Builder: SubComponentBuilder<AnimalComponent> {
        fun birdModule(module: BirdModule): Builder
    }

    fun inject(oneDagger: OneDagger)
}