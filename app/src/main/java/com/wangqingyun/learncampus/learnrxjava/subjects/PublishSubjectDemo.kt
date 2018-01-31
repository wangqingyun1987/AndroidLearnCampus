package com.wangqingyun.learncampus.learnrxjava.subjects

import android.util.Log
import io.reactivex.subjects.PublishSubject

/**
 * Created by wangqingyun on 31/01/2018.
 */

fun tryPublishSubject() {
    val subject = PublishSubject.create<String>()

    subject.subscribe {
        Log.d("WQY", "A : $it")
    }

    subject.map { it.length }.subscribe {
        Log.d("WQY", "B : $it")
    }

    subject.onNext("Madrid")
    subject.onNext("Barcelona")
    subject.onNext("Milan")
    subject.onComplete()
}

fun demoPublishSubject() {
    tryPublishSubject()
}