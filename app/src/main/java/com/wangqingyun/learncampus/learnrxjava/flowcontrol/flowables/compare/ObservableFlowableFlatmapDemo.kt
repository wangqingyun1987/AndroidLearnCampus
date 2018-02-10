package com.wangqingyun.learncampus.learnrxjava.flowcontrol.flowables.compare

import android.util.Log
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by qingyun.wang on 09/02/2018.
 */

/**
 * Observable.flatMap() has an unbounded queue, so emission cannot always be put in
 * */
private fun verifyObservableFlatmapNotExplode() {
    Observable.range(1, 3)
            .flatMap {
                Observable.range(1, 10000).subscribeOn(Schedulers.newThread())
            }
            .map {
                Thread.sleep(1)
                it
            }
            .reduce { accum: Int, next: Int -> accum + next }
            .subscribe {
                Log.d("WQY", "observable received : $it")
            }
}

/**
 * Flowable.flatMap() has a bounded queue, so too many emission from upstream can cause a
 * MissingBackpressureException
 *
 * so upstream of Flowable.flatMap()'s inner subscriber should handle backPressure, only
 *  send as many downstream as requested.
 *  note: Flowable.flatMap()'s inner subscriber will only request as many as buffer queue can put.
 *
 * MissingBackpressureException in this case won't be passed down to onError of final Subscriber,
 * it will actually crash the application
 */
private fun verifyFlowableFlatmapExplode() {
    Flowable.range(1, 3)
            .flatMap {
                Observable.range(1, 10000).toFlowable(BackpressureStrategy.MISSING).subscribeOn(Schedulers.newThread())
            }
            .map {
                Thread.sleep(1)
                it
            }
            .reduce { accum: Int, next: Int -> accum + next }
            .subscribe( {
                Log.d("WQY", "flowable received : $it")
            }, {
                Log.d("WQY", "flowable error : $it")
            })
}

fun demoObservableFlowableFlatmapExplosion() {
    verifyObservableFlatmapNotExplode()

    verifyFlowableFlatmapExplode()
}