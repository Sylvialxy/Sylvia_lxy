package com.liuxinyu.dreamscape.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0004\u0012\u00020\u00060\bJ\"\u0010\u000b\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0004\u0012\u00020\u00060\bJ\u001c\u0010\f\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00060\bJ\"\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\bJ.\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/liuxinyu/dreamscape/data/repository/SleepRepository;", "", "()V", "sleepApiService", "Lcom/liuxinyu/dreamscape/network/SleepApiService;", "downloadData", "", "callback", "Lkotlin/Function1;", "", "Lcom/liuxinyu/dreamscape/data/model/SleepData;", "getHistoryData", "getRealtimeData", "uploadData", "sleepData", "", "userLogin", "credentials", "", "", "app_debug"})
public final class SleepRepository {
    private final com.liuxinyu.dreamscape.network.SleepApiService sleepApiService = null;
    
    public SleepRepository() {
        super();
    }
    
    public final void userLogin(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> credentials, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback) {
    }
    
    public final void getRealtimeData(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.liuxinyu.dreamscape.data.model.SleepData, kotlin.Unit> callback) {
    }
    
    public final void getHistoryData(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.liuxinyu.dreamscape.data.model.SleepData>, kotlin.Unit> callback) {
    }
    
    public final void uploadData(@org.jetbrains.annotations.NotNull()
    com.liuxinyu.dreamscape.data.model.SleepData sleepData, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback) {
    }
    
    public final void downloadData(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.liuxinyu.dreamscape.data.model.SleepData>, kotlin.Unit> callback) {
    }
}