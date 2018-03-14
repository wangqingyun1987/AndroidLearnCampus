package com.wangqingyun.learncampus.learndagger.components

import android.app.Activity
import com.wangqingyun.learncampus.App
import com.wangqingyun.learncampus.HomeActivity
import com.wangqingyun.learncampus.learndagger.components.utest.UTestComponent
import com.wangqingyun.learncampus.learntests.mocktio.UTestActivity
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by wangqingyun on 09/01/2018.
 */

@Module(subcomponents = [HomeComponent::class, UTestComponent::class])
abstract class AppBinders {
    @Binds @IntoMap @ActivityKey(HomeActivity::class)
    abstract fun bindsHome(builder: HomeComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds @IntoMap @ActivityKey(UTestActivity::class)
    abstract fun bindsUTest(builder: UTestComponent.Builder): AndroidInjector.Factory<out Activity>
}

@Component(modules = [AppBinders::class])
interface AppComponent {
    fun inject(app: App)
}