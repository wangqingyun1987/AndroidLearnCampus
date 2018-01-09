package com.wangqingyun.learncampus

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wangqingyun.learncampus.learndagger.modules.HEAD_LINE
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by wangqingyun on 09/01/2018.
 */

class HeadLineFragment : Fragment() {
    @Inject @field:Named(HEAD_LINE) lateinit var headLine: String

    override fun onAttach(activity: Activity) {
        AndroidSupportInjection.inject(this)
        super.onAttach(activity)

        Log.d("WQY", "head line is: $headLine")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_headline, container, false)
    }
}