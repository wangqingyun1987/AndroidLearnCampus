package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import io.reactivex.functions.Function

/**
 * Created by wangqingyun on 25/01/2018.
 */

fun tryDoOnNext() {
    Observable.just("Man City", "Man Utd", "Liverpool", "Arsenal")
            .doOnNext { Log.d("WQY", "do on next : $it") }
            .map { it.length }
            .subscribe { Log.d("WQY", "received : $it") }
}

/**
 * for Maybe and Single, doOnSuccess instead of doOnNext
 * */
fun tryDoOnSuccess() {
    Single.just("A").doOnSuccess {
        Log.d("WQY", "do on success : $it")
    }.subscribe({
        Log.d("WQY", "received : $it")
    }, {
        Log.d("WQY", "error : ${it.message}")
    })
}

fun tryDoOnComplete() {
    Observable.just("Ronaldo", "Beckham", "Zidanei")
            .doOnComplete {
                Log.d("WQY", "do on complete")
            }
            .subscribe({
                Log.d("WQY", "received : $it")
            }, {
                Log.d("WQY", "error : ${it.message}")
            }, {
                Log.d("WQY", "on complete")
            })
}

fun tryDoOnError() {
    Observable.range(1, 5)
            .doOnError { Log.d("WQY", "just error") }
            .map { it - 3 }
            .doOnError { Log.d("WQY", "subtraction error") }
            .map { 10 / it }
            .doOnError { Log.d("WQY", "division error") }
            .subscribe({
                Log.d("WQY", "received : $it")
            }, {
                Log.d("WQY", "error : ${it.message}")
            })
}

fun tryDoOnSubscribe() {
    Observable.just(1)
            .doOnSubscribe {
                Log.d("WQY", "doOnSubscribe after just")
            }
            .map { it * 10 }
            .doOnSubscribe {
                Log.d("WQY", "doOnSubscribe after map")
            }
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

fun tryDoOnDispose() {
    val dispose = Observable.just(10, 20, 30, 40, 50)
            .doOnDispose {
                Log.d("WQY", "do on dispose after just")
            }
            .map(object : Function<Int, Pair<Int, Int>> {
                var count = 0
                override fun apply(t: Int): Pair<Int, Int> {
                    return Pair(t, count++)
                }
            })
            .doOnDispose {
                Log.d("WQY", "do on dispose after map")
            }
            .delay {
                Observable.just(0).delay(it.second.toLong(), TimeUnit.SECONDS)
            }
            .doOnDispose {
                Log.d("WQY", "do on dispose after delay")
            }
            .map { it.first }
            .doOnDispose {
                Log.d("WQY", "do on dispose after map back")
            }
            .subscribe {
                Log.d("WQY", "Received : $ $it")
            }

    Thread(Runnable {
        Thread.sleep(3000)
        dispose.dispose()
    }).start()
}

fun tryDoFinally() {
    Observable.just("Barcelona", "Real Madrid", "Juventus")
            .doFinally {
                Log.d("WQY", "do finally")
            }
            .map {
                it.length
            }
            .subscribe {
                Log.d("WQY", "received : $it")
            }
}

fun tryDoOnOperators() {
    tryDoOnNext()
    tryDoOnSuccess()
    tryDoOnComplete()
    tryDoOnError()

    tryDoOnSubscribe()
    tryDoOnDispose()

    tryDoFinally()
}