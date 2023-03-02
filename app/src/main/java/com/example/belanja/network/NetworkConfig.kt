package com.example.belanja.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object NetworkConfig {
    fun getInterceptop():OkHttpClient{
        val interceptor = HttpLoggingInterceptor();
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    }
}