package com.liuxinyu.dreamscape.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    private const val DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"

    // 获取当前日期和时间的字符串表示
    fun getCurrentDateTimeString(format: String = DEFAULT_DATE_FORMAT): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    // 将日期字符串转换为 Date 对象
    fun parseDateString(dateString: String, format: String = DEFAULT_DATE_FORMAT): Date? {
        return try {
            val dateFormat = SimpleDateFormat(format, Locale.getDefault())
            dateFormat.parse(dateString)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    // 将 Date 对象格式化为字符串
    fun formatDate(date: Date, format: String = DEFAULT_DATE_FORMAT): String {
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(date)
    }

    // 获取两个日期之间的天数差
    fun getDaysDifference(startDate: Date, endDate: Date): Long {
        val startTime = startDate.time
        val endTime = endDate.time
        val difference = endTime - startTime
        return difference / (24 * 60 * 60 * 1000)
    }

    // 在当前日期基础上增加或减少天数
    fun addDaysToDate(date: Date, days: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_MONTH, days)
        return calendar.time
    }
}