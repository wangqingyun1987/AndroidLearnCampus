package com.wangqingyun.learncampus.learndagger

import android.util.Log
import com.wangqingyun.learncampus.learndagger.components.DaggerDmBdInstComponent
import com.wangqingyun.learncampus.learndagger.modules.DMBD_TITLE
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by wangqingyun on 22/02/2018.
 */

class DemoBindsInstance {
    @Inject @field:Named(DMBD_TITLE)
    lateinit var title: String

    private fun setDependencyInjection() {
        DaggerDmBdInstComponent.builder().nameSource { "欧阳古德" }.build().inject(this)
    }

    init {
        setDependencyInjection()

        Log.d("WQY", "my title is : $title")
    }
}