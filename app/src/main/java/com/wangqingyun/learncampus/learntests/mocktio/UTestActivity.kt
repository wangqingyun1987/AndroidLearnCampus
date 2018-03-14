package com.wangqingyun.learncampus.learntests.mocktio

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.wangqingyun.learncampus.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class UTestActivity : AppCompatActivity(), UTestContract.View {
    @Inject lateinit var presenter: UTestContract.Presenter

    private var uiReady = false

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utest)

        findViewById<Button>(R.id.touch_me).setOnClickListener {
            presenter.onMeTouched()
        }

        findViewById<View>(android.R.id.content).viewTreeObserver.addOnGlobalLayoutListener {
            uiReady = true
        }
    }

    override fun isUIReady() = uiReady

    @SuppressLint("WrongViewCast")
    override fun showTouchText(text: String) {
        findViewById<TextView>(R.id.show_touch).text = text
    }
}