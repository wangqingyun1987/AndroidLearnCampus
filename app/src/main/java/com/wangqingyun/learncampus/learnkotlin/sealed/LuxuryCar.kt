package com.wangqingyun.learncampus.learnkotlin.sealed

/**
 * Created by wangqingyun on 13/01/2018.
 *
 *  A sealed class can have subclasses, but all of them must be declared in the same file
 *  as the sealed class itself.
 *
 *  Note that classes which extend subclasses of a sealed class (indirect inheritors) can
 *  be placed anywhere, not necessarily in the same file.
 *
 *  A sealed class is abstract by itself, it cannot be instantiated directly and can
 *  have abstract members.
 *
 *  Sealed classes are not allowed to have non-private constructors (
 *  their constructors are private by default).
 */

sealed class LuxuryCar {
    fun drive() {}
}

class Porsche: LuxuryCar()

class Lamborghini: LuxuryCar()

class Maserati: LuxuryCar()

fun luxuryCarName(car: LuxuryCar) = when(car) {
    is Porsche -> "Porsche"
    is Lamborghini -> "Lamborghini"
    is Maserati -> "Maserati"
}