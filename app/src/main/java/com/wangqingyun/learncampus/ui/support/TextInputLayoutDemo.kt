package com.wangqingyun.learncampus.ui.support

import android.os.Build
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.view.ViewTreeObserver
import com.wangqingyun.learncampus.R

/**
 * Created by qingyun.wang on 02/02/2018.
 */

class TextInputLayoutDemo: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_text_input_layout_demo)

        val ti1 = findViewById<TextInputLayout>(R.id.text_input_1)
        val ti2 = findViewById<TextInputLayout>(R.id.text_input_2)

        ti1.disableInitAnim()
        ti2.disableInitAnim()
    }
}

private fun TextInputLayout.disableInitAnim() {
    isHintEnabled = false
    viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this)
            }
            isHintEnabled = true
        }
    })
}