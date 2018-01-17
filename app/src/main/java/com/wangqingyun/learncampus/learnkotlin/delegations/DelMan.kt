package com.wangqingyun.learncampus.learnkotlin.delegations

import android.util.Log

/**
 * Created by qingyun.wang on 16/01/2018.
 */

interface Son {
    fun supportParent()
}

interface Father {
    fun supportChild()
}

interface Husband {
    fun companyWife()
    fun supportWife()
}

class GoodSon: Son {
    override fun supportParent() {
        Log.d("WQY", "supprt parents")
    }
}

class GoodFather: Father {
    override fun supportChild() {
        Log.d("WQY", "support child")
    }
}

class GoodHusband: Husband {
    override fun companyWife() {
        Log.d("WQY", "company wife")
    }

    override fun supportWife() {
        Log.d("WQY", "support wife")
    }
}

class DelMan(son: Son, father: Father, husband: Husband): Son by son, Father by father, Husband by husband

fun tryDelegation() {
    val man = DelMan(GoodSon(), GoodFather(), GoodHusband())

    man.supportParent()
    man.supportChild()
    man.supportWife()
    man.companyWife()
}