package com.liuxinyu.dreamscape.ui.today

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import com.liuxinyu.dreamscape.R
import com.liuxinyu.dreamscape.data.model.SleepData
import com.liuxinyu.dreamscape.data.repository.SleepRepository


class TodayFragment : Fragment() {

    private val sleepRepository = SleepRepository()

    private lateinit var tvSleepTime: TextView
    private lateinit var tvSleepDuration: TextView
    private lateinit var tvSleepEfficiency: TextView
    private lateinit var barChart: BarChart
    private lateinit var pieChart: PieChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvSleepTime = view.findViewById(R.id.tvSleepTime)
        tvSleepDuration = view.findViewById(R.id.tvSleepDuration)
        tvSleepEfficiency = view.findViewById(R.id.tvSleepEfficiency)
        barChart = view.findViewById(R.id.barChart)
        pieChart = view.findViewById(R.id.pieChart)

        loadTodayData()
    }

    private fun loadTodayData() {
        sleepRepository.getRealtimeData { sleepData ->
            sleepData?.let {
                updateUI(it)
            }
        }
    }

    private fun updateUI(sleepData: SleepData) {
        tvSleepTime.text = sleepData.sleepTime
        tvSleepDuration.text = sleepData.sleepDuration.toString()
        tvSleepEfficiency.text = sleepData.sleepEfficiency.toString()

        drawBarChart(sleepData)
        drawPieChart(sleepData)
    }

    private fun drawBarChart(sleepData: SleepData) {
        val entries = arrayListOf<BarEntry>()
        entries.add(BarEntry(0f, sleepData.module1.toFloat()))
        entries.add(BarEntry(1f, sleepData.module2.toFloat()))
        // 添加其他模块的数据

        val barDataSet = BarDataSet(entries, "Sleep Modules")
        barDataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()

        val barData = BarData(barDataSet)
        barChart.data = barData

        // 配置其他 barChart 属性
        barChart.invalidate()
    }

    private fun drawPieChart(sleepData: SleepData) {
        val entries = arrayListOf<PieEntry>()
        entries.add(PieEntry(sleepData.indicator1.toFloat(), "Indicator 1"))
        entries.add(PieEntry(sleepData.indicator2.toFloat(), "Indicator 2"))
        // 添加其他指标的数据

        val pieDataSet = PieDataSet(entries, "Sleep Indicators")
        pieDataSet.colors = ColorTemplate.COLORFUL_COLORS.asList()

        val pieData = PieData(pieDataSet)
        pieChart.data = pieData

        // 配置其他 pieChart 属性
        pieChart.invalidate()
    }
}