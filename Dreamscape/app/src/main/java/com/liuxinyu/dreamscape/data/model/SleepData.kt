package com.liuxinyu.dreamscape.data.model

data class SleepData(
    val date: String,
    val sleepTime: String,
    val sleepDuration: Double,
    val sleepEfficiency: Double,
    val module1: Float,  // 例如，这是模块1的数据
    val module2: Float,  // 例如，这是模块2的数据
    val indicator1: Float,  // 例如，这是指标1的数据
    val indicator2: Float  // 例如，这是指标2的数据
)