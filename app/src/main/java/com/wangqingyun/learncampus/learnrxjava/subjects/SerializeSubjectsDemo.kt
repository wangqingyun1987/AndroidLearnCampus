package com.wangqingyun.learncampus.learnrxjava.subjects

import android.util.Log
import io.reactivex.subjects.PublishSubject

/**
 * Created by wangqingyun on 31/01/2018.
 */

fun trySerializeSubjects() {
    val subject = PublishSubject.create<String>().toSerialized()

    subject.subscribe {
        Log.d("WQY", "received $it on ${Thread.currentThread().id}")
    }

    Thread(Runnable {
        Thread.sleep(300)

        subject.onNext("A")
        subject.onNext("B")
        subject.onNext("C")
        subject.onNext("D")
        subject.onNext("E")
    }).start()

    Thread(Runnable {
        Thread.sleep(300)

        subject.onNext("1")
        subject.onNext("2")
        subject.onNext("3")
        subject.onNext("4")
        subject.onNext("5")
    }).start()
}

fun demoSerializeSubjects() {
    trySerializeSubjects()
}