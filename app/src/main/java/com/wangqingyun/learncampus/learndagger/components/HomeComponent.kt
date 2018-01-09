package com.wangqingyun.learncampus.learndagger.components

import com.wangqingyun.learncampus.HomeActivity
import com.wangqingyun.learncampus.learndagger.modules.HomeModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by wangqingyun on 09/01/2018.
 */

@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent: AndroidInjector<HomeActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeActivity>()
}