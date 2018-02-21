package com.wangqingyun.learncampus.learnrxjava.test.nonblocking

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 21/02/2018.
 */

fun getTenElements() = Observable.interval(100, TimeUnit.MILLISECONDS).take(10)