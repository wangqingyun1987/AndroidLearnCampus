package com.wangqingyun.learncampus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wangqingyun.learncampus.learndagger.modules.HOME_TITLE
import dagger.android.AndroidInjection
import javax.inject.Inject
import javax.inject.Named

class HomeActivity : AppCompatActivity() {
    @Inject @field:Named(HOME_TITLE) lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Log.d("WQY", "home title: $title")
    }
}
