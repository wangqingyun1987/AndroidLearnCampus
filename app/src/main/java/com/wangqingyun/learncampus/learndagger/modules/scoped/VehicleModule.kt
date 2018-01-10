package com.wangqingyun.learncampus.learndagger.modules.scoped

import com.wangqingyun.learncampus.learndagger.models.scoped.Vehicle
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton

/**
 * Created by wangqingyun on 10/01/2018.
 */

@Module
class VehicleModule {
    @Singleton
    @Provides
    fun provideVehicle() = Vehicle("Land ${Random().nextInt()}")
}