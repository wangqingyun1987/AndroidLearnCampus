package com.wangqingyun.learncampus.learndagger

import android.util.Log
import com.wangqingyun.learncampus.learndagger.components.AnimalComponent
import com.wangqingyun.learncampus.learndagger.components.DaggerHumanComponent
import com.wangqingyun.learncampus.learndagger.models.Dog
import com.wangqingyun.learncampus.learndagger.models.Staff
import javax.inject.Inject

/**
 * Created by wangqingyun on 09/01/2018.
 */

class OneDagger {
    @Inject lateinit var staff: Staff
    @Inject lateinit var dog: Dog

    init {
        (DaggerHumanComponent.builder().build().getBuildsMap()[OneDagger::class.java]
                as? AnimalComponent.Builder)?.build()?.inject(this)

        Log.d("WQY", "--> " + staff.name + " . " + dog.color)
    }
}