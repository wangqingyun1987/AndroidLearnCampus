package com.wangqingyun.learncampus.learnkotlin.inlinefun

/**
 * Created by wangqingyun on 18/01/2018.
 *
 * In Kotlin, we can only use a normal, unqualified return to exit a named function or an
 * anonymous function. This means that to exit a lambda, we have to use a label, and a bare
 * return is forbidden inside a lambda, because a lambda can not make the enclosing function return
 *
 * But if the function the lambda is passed to is inlined, the return can be inlined as well,
 * so it is allowed:
 *
 * 1 -> lambda is not allowed to return without a label
 * 2 -> lambda passed to inline function can return without a label, which will return from calling sites
 * 3 -> for lambda passed to inline function, if noinline is applied, also cannot return without a label
 * 4 -> lambda passed to inline function cannot be called inside another context (like a new Runnable),
 *      because it may contain return without label, but this can be remedied by crossinline, which
 *      prohibits the lambda from return without a label
 */

inline fun goJapan(japan: () -> Unit) {
    //
}

@Suppress("NOTHING_TO_INLINE")
inline fun goKorea(noinline korea: () -> Unit) {
    val run = object: Runnable {
        override fun run() {
            korea()
        }
    }
    run.run()
}

inline fun goChina(crossinline china: () -> Unit) {
    val run = Runnable {
        china()
    }
    run.run()
}

fun hasZeros(ints: List<Int>): Boolean {
    ints.forEach {
        if (it == 0) return true // returns from hasZeros
    }
    return false
}

fun tryNonLocalReturn() {
    goJapan {
        return
    }

    goKorea {
        return@goKorea
    }

    goChina {
        return@goChina
    }
}