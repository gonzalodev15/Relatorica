package com.example.relatorica.logic.network

import com.androidnetworking.interceptors.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {
    companion object{

        val BASE_URL = "https://18.188.102.230/Relatorica/"
        const val PARENTS = "fatherapi/fathers"
        private val MAX_TIME = 300
    }
    val service: RelatoricaServices

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder().readTimeout(MAX_TIME.toLong(), TimeUnit.SECONDS)
            .connectTimeout(MAX_TIME.toLong(), TimeUnit.SECONDS).addInterceptor(interceptor).build()

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
                .build()

        service = retrofit.create(RelatoricaServices::class.java)
    }
}