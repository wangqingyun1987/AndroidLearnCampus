package com.wangqingyun.learncampus.learnandroid.parcelables

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by wangqingyun on 23/02/2018.
 */

@SuppressLint("ParcelCreator")
@Parcelize
data class Department(
        val manager: String,
        val individuals: List<String>
): Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Division(
        val supervisor: String,
        val departments: List<Department>
): Parcelable