package com.wangqingyun.learncampus.learndagger.modules

import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by wangqingyun on 09/01/2018.
 */

const val HOME_TITLE = "HomeTitle"

@Module
class HomeModule {
    @Provides
    @Named(HOME_TITLE)
    fun providesTitle() = "大明帝国的崛起！！！"
}