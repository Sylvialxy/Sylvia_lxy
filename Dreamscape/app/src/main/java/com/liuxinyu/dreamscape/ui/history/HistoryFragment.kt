package com.liuxinyu.dreamscape.ui.history

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.liuxinyu.dreamscape.R
import com.liuxinyu.dreamscape.util.Utils.showToast
import com.liuxinyu.dreamscape.view.CalendarView
import java.text.SimpleDateFormat
import java.util.*


class HistoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calendarView: CalendarView = view.findViewById(R.id.calendarView)

        calendarView.setOnDateClickListener(object : CalendarView.OnDateClickListener {
            override fun onDateClick(date: Calendar) {
                // 处理日期点击事件
                val formattedDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date.time)
                // 这里可以进行相应的操作，比如显示该日期的睡眠时长
                showToast(requireActivity(),"Clicked on $formattedDate")
            }
        })
    }


}