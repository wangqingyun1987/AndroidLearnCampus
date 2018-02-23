package com.wangqingyun.learncampus.learndagger

/**
 * Created by wangqingyun on 09/01/2018.
 */

interface SubComponentBuilder<out A> {
    fun build(): A
}