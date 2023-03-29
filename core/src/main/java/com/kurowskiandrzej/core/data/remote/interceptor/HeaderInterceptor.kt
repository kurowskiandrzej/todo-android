package com.kurowskiandrzej.core.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.util.Locale

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("User-Agent", "Android")
            .addHeader("Accept-Language", Locale.getDefault().language)
            .build()
        return chain.proceed(request)
    }
}