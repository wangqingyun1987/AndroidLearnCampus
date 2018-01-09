package com.wangqingyun.learncampus.learndagger.components

import android.support.v4.app.Fragment
import com.wangqingyun.learncampus.HeadLineFragment
import com.wangqingyun.learncampus.HomeActivity
import com.wangqingyun.learncampus.learndagger.modules.HomeModule
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

/**
 * Created by wangqingyun on 09/01/2018.
 */

@Subcomponent(modules = arrayOf(HomeModule::class, HomeBinders::class))
interface HomeComponent: AndroidInjector<HomeActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeActivity>()
}

@Module(subcomponents = arrayOf(HeadLineComponent::class))
abstract class HomeBinders {
    @Binds
    @IntoMap
    @FragmentKey(HeadLineFragment::class)
    abstract fun bindHeadLine(buider: HeadLineComponent.Builder): AndroidInjector.Factory<out Fragment>
}