package com.liuxinyu.dreamscape.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.liuxinyu.dreamscape.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class SleepDurationAdapter(private val data: List<SleepDuration>) :
    RecyclerView.Adapter<SleepDurationAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val barChart: BarChart = itemView.findViewById(R.id.barChart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sleep_duration, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entries = ArrayList<BarEntry>()
        val labels = ArrayList<String>()

        // 将每个日期对应的睡眠时长转换为 BarEntry 对象，并添加到列表中
        data.forEachIndexed { index, sleepDuration ->
            entries.add(BarEntry(index.toFloat(), sleepDuration.duration.toFloat()))
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(sleepDuration.date)
            // 将日期格式化为字符串，并作为横坐标标签
            labels.add(SimpleDateFormat("MM/dd", Locale.getDefault()).format(date))
        }

        // 创建一个 BarDataSet 对象，并设置数据集的标签
        val dataSet = BarDataSet(entries, "Sleep Duration")

        // 创建一个 BarData 对象，并将数据集添加到其中
        val data = BarData(dataSet)

        // 设置柱状图的数据
        holder.barChart.data = data

        // 获取 X 轴对象
        val xAxis = holder.barChart.xAxis

        // 隐藏顶部的横坐标线
        xAxis.setDrawAxisLine(false)

        // 设置 X 轴的位置为底部
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        // 设置 X 轴的标签为日期
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)

        // 设置柱状图柱子颜色
        dataSet.color = ContextCompat.getColor(holder.itemView.context, R.color.white)

        // 设置柱状图文本颜色
        dataSet.valueTextColor = ContextCompat.getColor(holder.itemView.context, R.color.white)


        //设置柱状图的所有组件为白色
        holder.barChart.legend.textColor = ContextCompat.getColor(holder.itemView.context, R.color.white)
        holder.barChart.description.textColor = ContextCompat.getColor(holder.itemView.context, R.color.white)
        holder.barChart.xAxis.textColor = ContextCompat.getColor(holder.itemView.context, R.color.white)
        holder.barChart.axisLeft.textColor = ContextCompat.getColor(holder.itemView.context, R.color.white)
        holder.barChart.axisRight.textColor = ContextCompat.getColor(holder.itemView.context, R.color.white)

        // 刷新柱状图
        holder.barChart.invalidate()
    }

    override fun getItemCount(): Int {
        return 1 // 因为只有一个柱状图，所以返回 1
    }
}