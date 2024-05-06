package com.example.mgafinalexam.network

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {
    companion object {
        private fun provideOkHttpClient(context: Context): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor(context))
                .build()
        }
        fun configNetwork(context: Context): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://104.248.144.154:8081")
                .client(provideOkHttpClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun service(context: Context): ApiService {
            return configNetwork(context).create(ApiService::class.java)
        } }

}