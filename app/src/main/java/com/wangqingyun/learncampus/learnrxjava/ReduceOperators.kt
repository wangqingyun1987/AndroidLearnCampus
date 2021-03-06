package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable

/**
 * Created by wangqingyun on 23/01/2018.
 *
 * You will likely have moments where you want to take a series of emissions and
 * consolidate them into a single emission (usually emitted through a Single).
 */

fun tryCount() {
    Observable.just("A", "B", "C", "D", "E", "F", "G")
            .count()
            .subscribe {
                count -> Log.d("WQY", "we have $count letters")
            }
}

fun tryReduce() {
    Observable.range(1, 1000)
            .reduce {
                accum: Int, next: Int -> accum + next
            }
            .subscribe {
                Log.d("WQY", "sum of 1 to 1000 is : $it")
            }
}

fun tryAll() {
    Observable.just("India", "France", "Russia")
            .all { !it.startsWith("A") }
            .subscribe {
                yes -> Log.d("WQY", "all passed : $yes")
            }
}

fun tryAny() {
    Observable.just(100, 17, 98, 16, 22)
            .any { it % 3 == 0 }
            .subscribe {
                yes -> Log.d("WQY", "found 3 : $yes")
            }
}

fun tryContains() {
    Observable.range(1, 1000)
            .contains(777)
            .subscribe {
                yes -> Log.d("WQY", "found 777 : $yes")
            }
}

fun tryReducingOperators() {
    tryCount()

    tryReduce()

    tryAll()

    tryAny()

    tryContains()
}