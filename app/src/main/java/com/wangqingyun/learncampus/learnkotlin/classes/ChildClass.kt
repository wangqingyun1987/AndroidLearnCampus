package com.wangqingyun.learncampus.learnkotlin.classes

/**
 * Created by wangqingyun on 13/01/2018.
 */

class ChildClass: BaseClass() {
    override val correct get() = "A" == "B"
}