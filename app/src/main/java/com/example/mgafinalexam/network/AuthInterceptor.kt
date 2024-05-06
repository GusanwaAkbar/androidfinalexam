package com.example.mgafinalexam.network

import android.content.Context
import com.example.mgafinalexam.utils.PrefManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = PrefManager.getToken(context) ?: ""
        val request = chain.request().newBuilder()
            .addHeader("Authorization", token)
            .build()
        return chain.proceed(request)
    }
}
