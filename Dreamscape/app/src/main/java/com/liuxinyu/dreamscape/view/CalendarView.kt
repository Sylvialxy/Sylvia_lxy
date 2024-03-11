package com.liuxinyu.dreamscape.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.liuxinyu.dreamscape.R
import java.text.SimpleDateFormat
import java.util.*

class CalendarView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    private var currentDate: Calendar = Calendar.getInstance()

    init {
        orientation = VERTICAL
        setupCalendar()
    }

    private fun setupCalendar() {
        // 获取日历的年月
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)

        // 设置日历标题
        val headerView = LayoutInflater.from(context).inflate(R.layout.calendar_header, this, false)
        val tvHeader = headerView.findViewById<TextView>(R.id.tvCalendarHeader)
        tvHeader.text = context.getString(R.string.month_year_format,year, month + 1,)
        addView(headerView)

        // 创建日历表格
        val calendarGrid = LayoutInflater.from(context).inflate(R.layout.calendar_grid, this, false) as LinearLayout
        addView(calendarGrid)

        // 获取本月第一天的星期和本月总天数
        val firstDayOfWeek = getFirstDayOfWeek(year, month)
        val daysInMonth = getDaysInMonth(year, month)

        // 填充日历表格
        for (i in 1..daysInMonth) {
            val dayView = LayoutInflater.from(context).inflate(R.layout.calendar_day, calendarGrid, false) as TextView
            dayView.text = i.toString()

            // 处理日期点击事件
            dayView.setOnClickListener {
                val clickedDate = Calendar.getInstance().apply {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, month)
                    set(Calendar.DAY_OF_MONTH, i)
                }
                onDateClickListener?.onDateClick(clickedDate)
            }

            calendarGrid.addView(dayView)

            // 添加空白占位符，使第一天正确对应星期
            if (i == 1 && firstDayOfWeek > 1) {
                for (j in 1 until firstDayOfWeek) {
                    val placeholderView = View(context)
                    calendarGrid.addView(placeholderView)
                }
            }
        }
    }

    // 设置当前日期
    fun setCurrentDate(calendar: Calendar) {
        currentDate = calendar
        removeAllViews()
        setupCalendar()
    }

    // 获取本月第一天的星期
    private fun getFirstDayOfWeek(year: Int, month: Int): Int {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, 1)
        }
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    // 获取本月总天数
    private fun getDaysInMonth(year: Int, month: Int): Int {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
        }
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    // 日期点击监听器
    interface OnDateClickListener {
        fun onDateClick(date: Calendar)
    }

    private var onDateClickListener: OnDateClickListener? = null

    fun setOnDateClickListener(listener: OnDateClickListener) {
        onDateClickListener = listener
    }
}