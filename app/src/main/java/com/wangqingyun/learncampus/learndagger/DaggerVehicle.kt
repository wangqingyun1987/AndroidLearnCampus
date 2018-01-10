package com.wangqingyun.learncampus.learndagger

import android.util.Log
import com.wangqingyun.learncampus.learndagger.components.scoped.DaggerVehicleComponent
import com.wangqingyun.learncampus.learndagger.models.scoped.Vehicle
import javax.inject.Inject

/**
 * Created by wangqingyun on 10/01/2018.
 */

class DaggerVehicle {
    @Inject lateinit var vehicle: Vehicle

    init {
        val subVehicle = SubVehicle()

        val component = DaggerVehicleComponent.builder().build()

        component.inject(this)
        component.inject(subVehicle)

        doWork()
        subVehicle.doWork()
    }

    fun doWork() {
        Log.d("WQY", "main vehicle --> $vehicle ... ${vehicle.hashCode()}")
    }
}

class SubVehicle {
    @Inject lateinit var vehicle: Vehicle

    fun doWork() {
        Log.d("WQY", "sub vehicle --> $vehicle ... ${vehicle.hashCode()}")
    }
}