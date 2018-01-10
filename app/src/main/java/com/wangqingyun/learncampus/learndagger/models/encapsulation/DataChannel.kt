package com.wangqingyun.learncampus.learndagger.models.encapsulation

import java.util.*

/**
 * Created by wangqingyun on 10/01/2018.
 */

data class DataItem(val value: Int)

interface DataChannel {
    fun readData(): DataItem
}

class DataChannelImpl: DataChannel {
    private val value = Math.abs(Random().nextInt() % 1025)

    override fun readData(): DataItem {
        return DataItem(value)
    }
}