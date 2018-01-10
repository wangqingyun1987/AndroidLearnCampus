package com.wangqingyun.learncampus.learndagger

import android.util.Log
import com.wangqingyun.learncampus.learndagger.components.scoped.DaggerVehicleComponent
import com.wangqingyun.learncampus.learndagger.models.scoped.Car
import com.wangqingyun.learncampus.learndagger.models.scoped.Vehicle
import javax.inject.Inject

/**
 * Created by wangqingyun on 10/01/2018.
 */

class DaggerVehicle {
    @Inject lateinit var vehicle: Vehicle
    @Inject lateinit var car: Car

    init {
        val subVehicle = SubVehicle()

        val component = DaggerVehicleComponent.builder().build().getCarBuilder().build()

        component.inject(this)
        component.inject(subVehicle)

        doWork()
        subVehicle.doWork()
    }

    fun doWork() {
        Log.d("WQY", "main vehicle --> $vehicle ... ${vehicle.hashCode()}")
        Log.d("WQY", "main car --> $car")
    }
}

class SubVehicle {
    @Inject lateinit var vehicle: Vehicle
    @Inject lateinit var car: Car

    fun doWork() {
        Log.d("WQY", "sub vehicle --> $vehicle ... ${vehicle.hashCode()}")
        Log.d("WQY", "sub car --> $car")
    }
}