package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 22/01/2018.
 */

fun tryCreate() {
    var emitter: ObservableEmitter<Int>? = null
    val observable = Observable.create<Int> {
        emitter = it
        emitter?.setCancellable { Log.d("WQY", "remove resources upon disposal") }
    }

    observable.take(2)
            .subscribe { Log.d("WQY", "first two element : $it") }

    emitter?.onNext(3)
    emitter?.onNext(7)
    emitter?.onNext(11)
    emitter?.onNext(13)
    emitter?.onNext(17)
}

fun tryJust() {
    Observable.just("A", "B", "C")
            .subscribe { Log.d("WQY", "just : $it") }
}

fun tryFromIterable() {
    Observable.fromIterable(listOf("贝肯鲍尔", "穆勒", "克林斯曼", "马特乌斯", "克洛泽"))
            .subscribe { Log.d("WQY", "from iterable : $it") }
}

fun tryRange() {
    Observable.range(101, 10)
            .subscribe { Log.d("WQY", "range item : $it") }
}

fun tryInterval() {
    Observable.interval(300, TimeUnit.MILLISECONDS)
            .subscribe { Log.d("WQY", "interval item : $it") }
}

fun tryFromFuture() {
    val executor = Executors.newSingleThreadExecutor()
    val task = Callable<String> {
        return@Callable "羽林卫"
    }

    Observable.fromFuture(executor.submit(task))
            .subscribe { Log.d("WQY", "今夜值班 : $it") }
}

fun tryEmpty() {
    Observable.empty<Int>()
            .subscribe({
                Log.d("WQY", "empty onNext : $it")
            }, {
                Log.d("WQY", "empty error")
            }, {
                Log.d("WQY", "empty onComplete")
            })
}

fun tryNever() {
    Observable.never<Int>().subscribe({
        Log.d("WQY", "never onNext")
    }, {
        Log.d("WQY", "never onError")
    }, {
        Log.d("WQY", "never onComplete")
    })
}

fun tryError() {
    Observable.error<String> {
        NullPointerException("傻逼，NPE啦")
    }.subscribe({
        Log.d("WQY", "error onNext : $it")
    }, {
        Log.d("WQY", "error onError : ${it.message}")
    }, {
        Log.d("WQY", "error onComplete")
    })
}

fun tryDefer() {
    var name = "巴塞罗那"

    val observable = Observable.defer {
        Observable.just(name)
    }

    observable.subscribe {
        Log.d("WQY", "defer 1 : $it")
    }

    name = "皇家马德里"

    observable.subscribe {
        Log.d("WQY", "defer 2 : $it")
    }
}

fun tryCreateOperators() {
    tryCreate()

    tryJust()

    tryFromIterable()

    tryRange()

    tryInterval()

    tryFromFuture()

    tryEmpty()

    tryNever()

    tryError()

    tryDefer()
}