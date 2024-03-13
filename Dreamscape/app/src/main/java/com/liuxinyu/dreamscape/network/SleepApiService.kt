package com.liuxinyu.dreamscape.network

import com.liuxinyu.dreamscape.data.model.HistoryData
import com.liuxinyu.dreamscape.data.model.SleepData
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

// 定义与云平台交互的网络请求接口
// 包括用户登录、实时数据获取、历史数据获取、上传、下载等
interface SleepApiService {
    @POST("userLogin")
    fun userLogin(@Body credentials: Map<String, String>): Call<Unit>

    @GET("realtime")
    fun getRealtimeData(): Call<SleepData>

    @GET("history")
    fun getHistoryData(): Call<List<HistoryData>>

    @POST("upload")
    fun uploadData(@Body sleepData: SleepData): Call<Unit>

    @GET("download")
    fun downloadData(): Call<List<SleepData>>
}