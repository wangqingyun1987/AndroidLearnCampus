package com.wangqingyun.learncampus.learndagger.modules

import com.wangqingyun.learncampus.learndagger.models.Dog
import dagger.Module
import dagger.Provides

/**
 * Created by wangqingyun on 09/01/2018.
 */

@Module
class AnimalModule {
    @Provides
    fun provideDog() = Dog(100, "Red")
}