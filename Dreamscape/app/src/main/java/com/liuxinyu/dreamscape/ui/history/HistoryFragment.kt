package com.liuxinyu.dreamscape.ui.history

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.slider.Slider
import com.liuxinyu.dreamscape.R
import com.liuxinyu.dreamscape.data.model.HistoryData
import com.liuxinyu.dreamscape.data.model.SleepData
import com.liuxinyu.dreamscape.data.repository.SleepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.math.roundToInt


class HistoryFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var seekBar: Slider

    private val sleepRepository = SleepRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 初始化 RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SleepDurationAdapter(getSampleData())

        // 初始化 SeekBar
        val seekBar = view.findViewById<SeekBar>(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // 在此处理 SeekBar 进度变化的逻辑，例如滚动 RecyclerView 到相应位置
                // 你可能需要根据进度计算 RecyclerView 应该滚动到的位置
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // 在此处理开始拖动 SeekBar 的逻辑
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // 在此处理停止拖动 SeekBar 的逻辑
            }
        })
    }

    private fun getSampleData(): List<SleepDuration> {
        // 获取示例数据，这里假设你有一个 SleepDuration 类来表示每天的睡眠时长
        // 你可以根据实际需求获取你的睡眠时长数据
        return listOf(
            SleepDuration("2024-03-01", 7.5),
            SleepDuration("2024-03-02", 8.0),
            SleepDuration("2024-03-03", 7.0),
            // 添加更多数据...
        )
    }
}