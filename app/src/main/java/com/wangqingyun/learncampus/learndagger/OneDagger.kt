package com.wangqingyun.learncampus.learndagger

import android.util.Log
import com.wangqingyun.learncampus.learndagger.components.AnimalComponent
import com.wangqingyun.learncampus.learndagger.components.DaggerHumanComponent
import com.wangqingyun.learncampus.learndagger.models.Dog
import com.wangqingyun.learncampus.learndagger.models.Staff
import com.wangqingyun.learncampus.learndagger.modules.BIRD_DESC
import com.wangqingyun.learncampus.learndagger.modules.BirdModule
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by wangqingyun on 09/01/2018.
 */

class OneDagger {
    @Inject lateinit var staff: Staff
    @Inject lateinit var dog: Dog
    @Inject @field:Named(BIRD_DESC) lateinit var birdDesc: String

    init {
        (DaggerHumanComponent.builder().build().getBuildsMap()[OneDagger::class.java]
                as? AnimalComponent.Builder)?.birdModule(BirdModule(123052))?.build()?.inject(this)

        Log.d("WQY", "--> " + staff.name + " . " + dog.color + " . " + birdDesc)
    }
}