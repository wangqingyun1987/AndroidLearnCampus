package com.wangqingyun.learncampus.libraries.okhttp

import android.util.Log
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request

fun demoOkGet() {
    Completable.fromAction {
        val url = "https://en.wikipedia.org/wiki/Massachusetts_Institute_of_Technology"
        val request = Request.Builder()
                .url(url)
                .build()

        val okHttpClient = OkHttpClient.Builder()
                .followRedirects(false)
                .followSslRedirects(false)
                .addNetworkInterceptor(OkRandomUaInterceptor())
                .build()

        val response = okHttpClient.newCall(request).execute()
        Log.d("WQY", response.body()?.string()?.substring(1000, 1200) ?: "no body")
    }.subscribeOn(Schedulers.io()).subscribe()
}