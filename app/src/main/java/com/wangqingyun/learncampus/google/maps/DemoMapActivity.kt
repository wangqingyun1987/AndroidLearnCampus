package com.wangqingyun.learncampus.google.maps

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.SupportMapFragment
import com.wangqingyun.learncampus.R

class DemoMapActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_map)

        val mapFragment = SupportMapFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.demo_google_map, mapFragment)
        ft.commit()
    }
}