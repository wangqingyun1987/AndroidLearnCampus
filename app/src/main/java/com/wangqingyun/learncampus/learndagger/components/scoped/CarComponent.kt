package com.wangqingyun.learncampus.learndagger.components.scoped

import com.wangqingyun.learncampus.learndagger.DaggerVehicle
import com.wangqingyun.learncampus.learndagger.SubVehicle
import com.wangqingyun.learncampus.learndagger.modules.scoped.CarModule
import com.wangqingyun.learncampus.learndagger.scopes.CarScope
import dagger.Subcomponent

/**
 * Created by wangqingyun on 10/01/2018.
 */

@CarScope
@Subcomponent(modules = arrayOf(CarModule::class))
interface CarComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): CarComponent
    }

    fun inject(instance: DaggerVehicle)
    fun inject(instance: SubVehicle)
}