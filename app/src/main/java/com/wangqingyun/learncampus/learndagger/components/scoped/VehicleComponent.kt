package com.wangqingyun.learncampus.learndagger.components.scoped

import com.wangqingyun.learncampus.learndagger.modules.scoped.VehicleModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wangqingyun on 10/01/2018.
 */

@Singleton
@Component(modules = arrayOf(VehicleModule::class))
interface VehicleComponent {
    fun getCarBuilder(): CarComponent.Builder
}