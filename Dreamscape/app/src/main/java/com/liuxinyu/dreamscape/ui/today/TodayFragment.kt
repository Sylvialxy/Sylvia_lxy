package com.liuxinyu.dreamscape.ui.today

import android.graphics.Color
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
import com.yhd.sleepquality.SleepQualityView
import java.lang.reflect.Field;


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

        // 初始化 SleepQualityView
        val sleepView = view.findViewById<SleepQualityView>(R.id.sleepView)




        try {
            // Get the private textGrayColor field of SleepQualityView class
            val field: Field = SleepQualityView::class.java.getDeclaredField("textGrayColor")
            field.isAccessible = true // Set the field accessible
            val xTextRatioField: Field = SleepQualityView::class.java.getDeclaredField("xTextRatio")
            val yTextRatioField: Field = SleepQualityView::class.java.getDeclaredField("yTextRatio")
            xTextRatioField.isAccessible = true // Set the field accessible
            yTextRatioField.isAccessible = true // Set the field accessible


            // Modify textGrayColor field value to white
            field.setInt(sleepView, Color.WHITE)

            xTextRatioField.setFloat(sleepView, 0.1f)
            yTextRatioField.setFloat(sleepView, 0.1f)

            // Redraw the view to show the updated color
            sleepView.invalidate()

        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }



        // 设置数据源
        val timeArray = listOf(
            floatArrayOf(1f, 0.0f, 0.05f),
            floatArrayOf(2f, 0.05f, 0.1f),
            floatArrayOf(3f, 0.15f, 0.05f),
            // 添加更多数据...
        )
        val xAxisArray = listOf("23", "24", "1", "2", "3", "4", "5", "6", "7")
        sleepView.setDataSource(timeArray, xAxisArray)

        // 设置Y坐标描述符
        sleepView.setYAxisString("Wake", "Shallow", "Deep")


        // 设置横线的宽度
        sleepView.setWidthRatio(0.05f)

        // 设置颜色
        sleepView.setLineColor(
            Color.parseColor("#10e191"),
            Color.parseColor("#398eff"),
            Color.parseColor("#ffa239")
        )




        tvSleepTime = view.findViewById(R.id.tvSleepTime)
        tvSleepDuration = view.findViewById(R.id.tvSleepDuration)
        tvSleepEfficiency = view.findViewById(R.id.tvSleepEfficiency)
        pieChart = view.findViewById(R.id.pieChart1)

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

        drawPieChart(sleepData)
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