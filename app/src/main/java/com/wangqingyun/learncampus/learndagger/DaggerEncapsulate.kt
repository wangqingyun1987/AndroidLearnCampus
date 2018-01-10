package com.wangqingyun.learncampus.learndagger

import android.util.Log
import com.wangqingyun.learncampus.learndagger.components.encapsulation.DaggerEncAppComponent
import com.wangqingyun.learncampus.learndagger.models.encapsulation.DataChannel
import com.wangqingyun.learncampus.learndagger.modules.encapsulation.UI_TEXT
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by wangqingyun on 10/01/2018.
 */

class DaggerEncapsulate {
    @Inject lateinit var dataChannel: DataChannel
    @Inject @field:Named(UI_TEXT) lateinit var text: String

    init {
        val sub = SubEncapsulate()

        val component = DaggerEncAppComponent.builder().build().uiBuilder().build()
        component.inject(this)
        component.inject(sub)

        work()
        sub.work()
    }

    fun work() {
        Log.d("WQY", "main encap --> ${dataChannel.readData().value}, $text")
    }
}

class SubEncapsulate {
    @Inject lateinit var dataChannel: DataChannel
    @Inject @field:Named(UI_TEXT) lateinit var text: String

    fun work() {
        Log.d("WQY", "sub encap --> ${dataChannel.readData().value}, $text")
    }
}