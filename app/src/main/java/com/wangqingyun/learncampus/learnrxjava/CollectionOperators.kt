package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Created by wangqingyun on 23/01/2018.
 *
 * Collection operators will accumulate all emissions into a collection such as a list or map and
 * then emit that entire collection as a single emission. Collection operators are another form of
 * reducing operators since they consolidate emissions into a single one.
 *
 * Note that you should avoid reducing emissions into collections for the sake of it. It can
 * undermine the benefits of reactive programming where items are processed in a beginning-to-end,
 * one-at-a-time sequence. You only want to consolidate emissions into collections when you are
 * logically grouping them in some way.
 */


fun tryToList() {
    Observable.just("Hilter", "Napolean", "Starlin")
            .toList()
            .subscribe {
                list -> Log.d("WQY", "list : $list")
            }
}

fun trySortedList() {
    Observable.just("Barcelona", "Real Madrid", "Bayern Munich", "AC Milan", "Inter Milan")
            .toSortedList {
                o1, o2 -> o1.length - o2.length
            }
            .subscribe {
                list -> Log.d("WQY", "sorted list : $list")
            }
}

fun tryCollectionOperators() {
    tryToList()

    trySortedList()
}