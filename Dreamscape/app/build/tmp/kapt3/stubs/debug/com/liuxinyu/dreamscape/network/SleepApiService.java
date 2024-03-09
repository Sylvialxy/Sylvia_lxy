package com.liuxinyu.dreamscape.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003H\'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u0005H\'J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0014\b\u0001\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/liuxinyu/dreamscape/network/SleepApiService;", "", "downloadData", "Lretrofit2/Call;", "", "Lcom/liuxinyu/dreamscape/data/model/SleepData;", "getHistoryData", "getRealtimeData", "uploadData", "", "sleepData", "userLogin", "credentials", "", "", "app_debug"})
public abstract interface SleepApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "userLogin")
    public abstract retrofit2.Call<kotlin.Unit> userLogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.Map<java.lang.String, java.lang.String> credentials);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "realtime")
    public abstract retrofit2.Call<com.liuxinyu.dreamscape.data.model.SleepData> getRealtimeData();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "history")
    public abstract retrofit2.Call<java.util.List<com.liuxinyu.dreamscape.data.model.SleepData>> getHistoryData();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "upload")
    public abstract retrofit2.Call<kotlin.Unit> uploadData(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.liuxinyu.dreamscape.data.model.SleepData sleepData);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "download")
    public abstract retrofit2.Call<java.util.List<com.liuxinyu.dreamscape.data.model.SleepData>> downloadData();
}