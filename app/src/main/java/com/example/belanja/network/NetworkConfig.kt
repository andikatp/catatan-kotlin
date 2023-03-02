package com.example.belanja.network
import com.example.belanja.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkConfig {
    fun getInterceptop():OkHttpClient{
        val interceptor = HttpLoggingInterceptor();
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL).client(getInterceptop()).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun service() = getRetrofit().create(CatatanPenjualanService::class.java)
}