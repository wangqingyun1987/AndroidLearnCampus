package com.wangqingyun.learncampus.utils

import com.wangqingyun.learncampus.learnandroid.parcelables.Department
import com.wangqingyun.learncampus.learnandroid.parcelables.Division

/**
 * Created by wangqingyun on 23/02/2018.
 */

fun getSampleParcDataList() = arrayListOf(
        Division("Asia", listOf(
                Department(
                        "China",
                        listOf("Japan", "Korea", "Vietnam")
                ),
                Department(
                        "Russia",
                        listOf("Ukraine", "Belarus", "Latvia")
                )
        )),
        Division("Cars", listOf(
                Department(
                        "Germany",
                        listOf("BMW", "Mercedes")
                )
        ))
)