package com.liuxinyu.dreamscape.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val BASE_URL = "http://10.231.33.41:4523/m1/4094175-0-default/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val sleepApiService: SleepApiService = retrofit.create(SleepApiService::class.java)
}