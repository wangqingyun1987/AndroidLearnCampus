package com.wangqingyun.learncampus.learnrxjava.subjects

import android.util.Log
import io.reactivex.subjects.AsyncSubject

/**
 * Created by wangqingyun on 31/01/2018.
 */

fun tryAsyncSubject() {
    val subject = AsyncSubject.create<String>()

    subject.subscribe({
        Log.d("WQY", "A : $it")
    }, {
        Log.d("WQY", "error : ${it.message}")
    }, {
        Log.d("WQY", "A complete")
    })

    subject.onNext("Brazil")
    subject.onNext("Argentina")
    subject.onNext("Spain")
    subject.onComplete()

    subject.subscribe({
        Log.d("WQY", "B : $it")
    }, {
        Log.d("WQY", "error : ${it.message}")
    }, {
        Log.d("WQY", "B complete")
    })
}

fun demoAsyncSubject() {
    tryAsyncSubject()
}