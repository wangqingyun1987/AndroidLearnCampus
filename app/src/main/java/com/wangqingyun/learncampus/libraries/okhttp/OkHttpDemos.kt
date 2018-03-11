package com.wangqingyun.learncampus.libraries.okhttp

import android.util.Log
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.nio.charset.Charset

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

fun demoOkPost() {
    val requestBody = FormBody.Builder(Charset.forName("UTF-8"))
            .add("id", "11056")
            .add("name", "Hanks")
            .build()

    val request = Request.Builder()
            .url("FORM_URL")
            .post(requestBody)
            .build()

    val okHttpClient = OkHttpClient.Builder()
            .followRedirects(false)
            .followSslRedirects(false)
            .addNetworkInterceptor(OkRandomUaInterceptor())
            .build()

    val response = okHttpClient.newCall(request).execute()
}