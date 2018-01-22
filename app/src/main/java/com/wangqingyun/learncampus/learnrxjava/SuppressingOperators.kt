package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 22/01/2018.
 */

fun Int.isPrime(): Boolean {
    val upper = Math.sqrt(toDouble()).toInt()

    Log.d("WQY", "upper : $upper")

    return (2..upper).none {
        Log.d("WQY", "number : $this")
        this % it == 0
    }
}

fun tryFilter() {
    Observable.range(10, 10)
            .filter { it % 2 == 0 }
            .subscribe { Log.d("WQY", "even number : $it") }
}

fun tryTakeWithAccount() {
    Observable.just("Japan", "China", "Korea", "Russia", "India", "Thailand")
            .take(2)
            .subscribe { Log.d("WQY", "first two: $it") }
}

fun tryTakeWithTime() {
    Observable.interval(500, TimeUnit.MILLISECONDS)
            .take(2, TimeUnit.SECONDS)
            .subscribe { Log.d("WQY", "first two second : $it") }
}

fun trySkip() {
    Observable.range(1, 30)
            .skip(25)
            .subscribe { Log.d("WQY", "last of 30s : $it") }
}

fun tryTakeWhile() {
    Observable.range(300, 50).takeWhile { !it.isPrime() }
            .subscribe { Log.d("WQY", "none prime : $it") }
}

fun tryTakeUntil() {
    var emitter: ObservableEmitter<Int>? = null
    val observabel = Observable.create<Int> {
        emitter = it
    }

    Observable.interval(500, TimeUnit.MILLISECONDS)
            .takeUntil(observabel)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { Log.d("WQY", "take until : $it") }

    Thread.sleep(2400)
    emitter?.onNext(1)
}

fun tryDistinct() {
    Observable.just("刘邦", "光武帝", "诸葛亮", "唐太宗李世民", "成吉思汗", "努尔哈赤")
            .distinct { it.length }
            .subscribe { Log.d("WQY", "名字长唯一的皇帝们 : $it") }
}

fun trySuppressing() {
    tryFilter()

    tryTakeWithAccount()
    tryTakeWithTime()

    trySkip()

    tryTakeWhile()

    tryTakeUntil()

    tryDistinct()
}