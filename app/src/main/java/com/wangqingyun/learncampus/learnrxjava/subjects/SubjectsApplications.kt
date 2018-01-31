package com.wangqingyun.learncampus.learnrxjava.subjects

import android.util.Log
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 31/01/2018.
 */

fun tryMergeFromDifferentSources() {
    val obA = Observable.interval(300, TimeUnit.MILLISECONDS)
            .take(10)
            .map { it + 1 }
            .map { "Upper passed ${it * 300} ms" }

    val obB = Observable.interval(1000, TimeUnit.MILLISECONDS)
            .take(5)
            .map { it + 1 }
            .doOnNext {
                Log.d("WQY", "lower emit : $it")
            }
            .map { "Lower passed $it seconds" }

    val subject = PublishSubject.create<String>()

    subject.subscribe {
        Log.d("WQY", "received : $it")
    }

    obA.subscribe(subject)
    obB.subscribe(subject)
}

fun demoSubjectsApplications() {
    tryMergeFromDifferentSources()
}