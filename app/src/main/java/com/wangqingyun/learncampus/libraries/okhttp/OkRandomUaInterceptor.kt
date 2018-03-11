package com.wangqingyun.learncampus.libraries.okhttp

import com.wangqingyun.learncampus.utils.RandomUserAgent
import okhttp3.Interceptor
import okhttp3.Response

class OkRandomUaInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
                .newBuilder()
                .header("User-Agent", RandomUserAgent.getRandomUserAgent())
                .build()

        return chain.proceed(request)
    }
}