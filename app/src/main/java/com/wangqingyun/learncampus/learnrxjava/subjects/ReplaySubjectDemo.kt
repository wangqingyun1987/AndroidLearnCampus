package com.wangqingyun.learncampus.learnrxjava.subjects

import android.util.Log
import io.reactivex.subjects.ReplaySubject

/**
 * Created by wangqingyun on 31/01/2018.
 */

fun tryReplaySubject() {
    val subject = ReplaySubject.create<String>()

    subject.subscribe {
        Log.d("WQY", "A : $it")
    }

    subject.onNext("China")
    subject.onNext("Japan")
    subject.onNext("Russia")
    subject.onComplete()

    subject.subscribe {
        Log.d("WQY", "B : $it")
    }
}

fun demoReplaySubject() {
    tryReplaySubject()
}