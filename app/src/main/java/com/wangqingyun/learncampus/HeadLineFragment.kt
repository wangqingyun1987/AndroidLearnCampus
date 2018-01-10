package com.wangqingyun.learncampus

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wangqingyun.learncampus.learndagger.DaggerEncapsulate
import com.wangqingyun.learncampus.learndagger.modules.HEAD_LINE
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by wangqingyun on 09/01/2018.
 */

class HeadLineFragment : Fragment() {
    private lateinit var headline: TextView

    override fun onAttach(activity: Activity) {
        AndroidSupportInjection.inject(this)
        super.onAttach(activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_headline, container, false)

        headline = view.findViewById(R.id.headline)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        headline.text = DaggerEncapsulate().work()
    }
}