package com.wangqingyun.learncampus.learnrxjava.subjects

import android.util.Log
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by wangqingyun on 31/01/2018.
 */

fun tryBehaviorSubject() {
    val subject = BehaviorSubject.create<String>()

    subject.subscribe {
        Log.d("WQY", "A : $it")
    }

    subject.onNext("Tokyo")
    subject.onNext("Singapore")
    subject.onNext("Hongkong")

    subject.subscribe {
        Log.d("WQY", "B : $it")
    }
}

fun demoBehaviorSubject() {
    tryBehaviorSubject()
}