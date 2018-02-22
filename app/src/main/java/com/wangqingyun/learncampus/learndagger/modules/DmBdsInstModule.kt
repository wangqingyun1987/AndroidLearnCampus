package com.wangqingyun.learncampus.learndagger.modules

import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by wangqingyun on 22/02/2018.
 */

const val DMBD_TITLE = "DMBD_TITLE"

@Module
class DmBdsInstModule {
    @Provides
    @Named(DMBD_TITLE)
    fun provideFullTitle(nameSource: () -> String) = "Mr: ${nameSource()}"
}