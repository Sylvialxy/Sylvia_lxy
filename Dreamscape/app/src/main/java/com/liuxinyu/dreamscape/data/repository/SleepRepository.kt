package com.liuxinyu.dreamscape.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.liuxinyu.dreamscape.data.model.SleepData
import com.liuxinyu.dreamscape.network.RetrofitClient


// 实现从本地数据库和云平台获取数据的逻辑
// 包括上传和下载睡眠数据
class SleepRepository {
    private val sleepApiService = RetrofitClient.sleepApiService

    fun userLogin(credentials: Map<String, String>, callback: (Boolean) -> Unit) {
        sleepApiService.userLogin(credentials).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                callback(response.isSuccessful)
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                callback(false)
            }
        })
    }

    fun getRealtimeData(callback: (SleepData?) -> Unit) {
        sleepApiService.getRealtimeData().enqueue(object : Callback<SleepData> {
            /*override fun onResponse(call: Call<SleepData>, response: Response<SleepData>) {
                callback(response.body())
            }

            override fun onFailure(call: Call<SleepData>, t: Throwable) {
                callback(null)
            }*/
            override fun onResponse(call: Call<SleepData>, response: Response<SleepData>) {
                if (response.isSuccessful) {
                    val sleepData = response.body()
                    Log.d("SleepData", "Received data from API: $sleepData")
                    callback(sleepData)
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("API Error", "Failed to fetch data from API. Error body: $errorBody")
                    Log.e("API Error", "Response code: ${response.code()}")
                    callback(null)
                }
            }

            override fun onFailure(call: Call<SleepData>, t: Throwable) {
                Log.e("API Error", "API call failed", t)
                callback(null)
            }


        })
    }

    fun getHistoryData(callback: (List<SleepData>?) -> Unit) {
        sleepApiService.getHistoryData().enqueue(object : Callback<List<SleepData>> {
            override fun onResponse(call: Call<List<SleepData>>, response: Response<List<SleepData>>) {
                callback(response.body())
            }

            override fun onFailure(call: Call<List<SleepData>>, t: Throwable) {
                callback(null)
            }
        })
    }

    fun uploadData(sleepData: SleepData, callback: (Boolean) -> Unit) {
        sleepApiService.uploadData(sleepData).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                callback(response.isSuccessful)
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                callback(false)
            }
        })
    }

    fun downloadData(callback: (List<SleepData>?) -> Unit) {
        sleepApiService.downloadData().enqueue(object : Callback<List<SleepData>> {
            override fun onResponse(call: Call<List<SleepData>>, response: Response<List<SleepData>>) {
                callback(response.body())
            }

            override fun onFailure(call: Call<List<SleepData>>, t: Throwable) {
                callback(null)
            }
        })
    }


}