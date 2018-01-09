package com.wangqingyun.learncampus.learndagger.components

import android.app.Activity
import com.wangqingyun.learncampus.App
import com.wangqingyun.learncampus.HomeActivity
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by wangqingyun on 09/01/2018.
 */

@Module(subcomponents = arrayOf(HomeComponent::class))
abstract class AppBinders {
    @Binds
    @IntoMap
    @ActivityKey(HomeActivity::class)
    abstract fun bindsHome(builder: HomeComponent.Builder): AndroidInjector.Factory<out Activity>
}

@Component(modules = arrayOf(AppBinders::class))
interface AppComponent {
    fun inject(app: App)
}