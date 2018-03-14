package com.wangqingyun.learncampus.learndagger.components.utest

import com.wangqingyun.learncampus.learntests.mocktio.*
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [UTestModule::class])
interface UTestComponent: AndroidInjector<UTestActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<UTestActivity>()
}

@Module
class UTestModule {
    @Provides
    fun provideView(activity: UTestActivity): UTestContract.View = activity

    @Provides
    fun providePresenter(impl: UTestPresenter): UTestContract.Presenter = impl

    @Provides
    fun provideUTestUsecase(impl: UTestUsecaseImpl): UTestUsecase = impl
}