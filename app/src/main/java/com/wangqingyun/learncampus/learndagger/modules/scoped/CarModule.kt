package com.wangqingyun.learncampus.learndagger.modules.scoped

import com.wangqingyun.learncampus.learndagger.models.scoped.Car
import com.wangqingyun.learncampus.learndagger.scopes.CarScope
import dagger.Module
import dagger.Provides
import java.util.*

/**
 * Created by wangqingyun on 10/01/2018.
 */

@Module
class CarModule {
    @CarScope
    @Provides
    fun provideCar() = Car("BMW", 120 + Random().nextInt() % 88)
}