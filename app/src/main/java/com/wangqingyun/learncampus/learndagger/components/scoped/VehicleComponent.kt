package com.wangqingyun.learncampus.learndagger.components.scoped

import com.wangqingyun.learncampus.learndagger.DaggerVehicle
import com.wangqingyun.learncampus.learndagger.SubVehicle
import com.wangqingyun.learncampus.learndagger.modules.scoped.VehicleModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wangqingyun on 10/01/2018.
 */

@Singleton
@Component(modules = arrayOf(VehicleModule::class))
interface VehicleComponent {
    fun inject(instance: DaggerVehicle)

    fun inject(instance: SubVehicle)
}