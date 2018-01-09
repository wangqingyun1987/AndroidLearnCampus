package com.wangqingyun.learncampus.learndagger.modules

import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by wangqingyun on 09/01/2018.
 */

const val HEAD_LINE = "HEAD_LINE"

@Module
class HeadlineModule {
    @Provides
    @Named(HEAD_LINE)
    fun provideHeadLine() = "屠呦呦获得诺贝尔奖，为中国人增光"
}