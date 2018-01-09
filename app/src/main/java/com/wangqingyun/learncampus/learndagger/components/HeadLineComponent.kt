package com.wangqingyun.learncampus.learndagger.components

import com.wangqingyun.learncampus.HeadLineFragment
import com.wangqingyun.learncampus.learndagger.modules.HeadlineModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by wangqingyun on 09/01/2018.
 */

@Subcomponent(modules = arrayOf(HeadlineModule::class))
interface HeadLineComponent: AndroidInjector<HeadLineFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HeadLineFragment>()
}