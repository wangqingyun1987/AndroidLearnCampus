package com.wangqingyun.learncampus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.wangqingyun.learncampus.learndagger.modules.HOME_TITLE
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import javax.inject.Inject
import javax.inject.Named
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector


class HomeActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject @field:Named(HOME_TITLE) lateinit var title: String

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Log.d("WQY", "home title: $title")

        supportFragmentManager.beginTransaction().replace(R.id.home_container, HeadLineFragment()).commit()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}
