package com.wangqingyun.learncampus

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.wangqingyun.learncampus.learnandroid.parcelables.Division

/**
 * Created by wangqingyun on 23/02/2018.
 */

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val list = intent.getParcelableArrayListExtra<Division>("parcelable_list")
        Log.d("WQY", "list size : ${list.size}")
        for (division in list) {
            Log.d("WQY", "supervisor : ${division.supervisor}")
            for (department in division.departments) {
                Log.d("WQY", "---- manager : ${department.manager}")
                Log.d("WQY", "---- ** individuals : ${department.individuals}")
            }
        }
    }
}