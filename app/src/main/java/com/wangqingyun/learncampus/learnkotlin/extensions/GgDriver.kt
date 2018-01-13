package com.wangqingyun.learncampus.learnkotlin.extensions

/**
 * Created by wangqingyun on 13/01/2018.
 *
 * The instance of the class in which the extension is declared is called dispatch receiver,
 * and the instance of the receiver type of the extension method is called extension receiver.
 *
 * In case of a name conflict between the members of the dispatch receiver and the extension
 * receiver, the extension receiver takes precedence. To refer to the member of the
 * dispatch receiver you can use the qualified this syntax.
 */

class GgDriver {
    fun drive() {

    }

    fun GgCar.run() {
        this@GgDriver.drive()
        drive()
    }
}