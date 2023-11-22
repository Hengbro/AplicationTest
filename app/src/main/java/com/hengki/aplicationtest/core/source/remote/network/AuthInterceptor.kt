package com.hengki.aplicationtest.core.source.remote.network

import com.hengki.aplicationtest.util.Constants
import com.hengki.aplicationtest.util.Prefs
import com.inyongtisto.myhelper.extension.def

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor to add auth token to requests
 */
class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header(Constants.AUTH_TOKEN, Prefs.token.def("token"))
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}