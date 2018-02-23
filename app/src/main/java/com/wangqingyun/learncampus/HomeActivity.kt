package com.wangqingyun.learncampus

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button
import com.wangqingyun.learncampus.learndagger.modules.HOME_TITLE
import com.wangqingyun.learncampus.utils.getSampleParcDataList
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

        findViewById<Button>(R.id.home_click).setOnClickListener {
            startSecondActivity()
        }

        supportFragmentManager.beginTransaction().replace(R.id.home_container, HeadLineFragment()).commit()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    private fun startSecondActivity() {
        val list = getSampleParcDataList()

        val intent = Intent(this@HomeActivity, SecondActivity::class.java)
        intent.putParcelableArrayListExtra("parcelable_list", list)
        startActivity(intent)
    }
}
