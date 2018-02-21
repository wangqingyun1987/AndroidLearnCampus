package com.wangqingyun.learncampus.learnrxjava.test.blocking

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wangqingyun on 21/02/2018.
 */

fun getFiveElements() = Observable.interval(300, TimeUnit.MILLISECONDS).take(5)