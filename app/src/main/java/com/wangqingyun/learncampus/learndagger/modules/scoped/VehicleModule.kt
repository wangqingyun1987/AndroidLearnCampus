package com.wangqingyun.learncampus.learndagger.modules.scoped

import com.wangqingyun.learncampus.learndagger.components.scoped.CarComponent
import com.wangqingyun.learncampus.learndagger.models.scoped.Vehicle
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by wangqingyun on 10/01/2018.
 */

const val YEAR_OF_MANU = "YEAR_OF_MANU"

@Module(subcomponents = arrayOf(CarComponent::class))
class VehicleModule {
    @Singleton
    @Provides
    fun provideVehicle() = Vehicle("Land ${Random().nextInt()}")

    @Provides
    @Named(YEAR_OF_MANU)
    fun provideYearOfMan(): Int = 2000 + Random().nextInt() % 24
}