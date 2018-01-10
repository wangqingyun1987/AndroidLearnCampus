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

    private val sub = SubEncapsulate()

    init {
        val component = DaggerEncAppComponent.builder().build().uiBuilder().build()
        component.inject(this)
        component.inject(sub)
    }

    fun work(): String = "代号${dataChannel.readData().value}, $text\n代号${sub.dataChannel.readData().value}, ${sub.text}"
}

class SubEncapsulate {
    @Inject lateinit var dataChannel: DataChannel
    @Inject @field:Named(UI_TEXT) lateinit var text: String

    fun work() {
        Log.d("WQY", "sub encap --> ${dataChannel.readData().value}, $text")
    }
}