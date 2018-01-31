package com.wangqingyun.learncampus.learnrxjava.subjects

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.UnicastSubject
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 31/01/2018.
 */

fun tryUnicastSubjectWithConnectable() {
    val subject = UnicastSubject.create<String>()

    /* since UnicastSubject can only be subscribed by one observer, so we use publish() to trick it,
        making it a Connectable */
    val source = subject.publish().autoConnect()

    Observable.interval(100, TimeUnit.MILLISECONDS)
            .take(20)
            .map { "item $it" }
            .subscribe(subject)

    Completable.timer(550, TimeUnit.MILLISECONDS)
            .andThen(source)
            .subscribe {
                Log.d("WQY", "A : $it")
            }

    Completable.timer(1250, TimeUnit.MILLISECONDS)
            .andThen(source)
            .subscribe {
                Log.d("WQY", "B : $it")
            }
}

fun demoUnicastSubject() {
    tryUnicastSubjectWithConnectable()
}