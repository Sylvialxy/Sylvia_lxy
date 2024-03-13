package com.liuxinyu.dreamscape.ui.history

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        viewPager = view.findViewById(R.id.viewPager)
        seekBar = view.findViewById(R.id.seekBar)

        lifecycleScope.launch {
            // Fetch history data from the repository
            val historyDataList = withContext(Dispatchers.IO) {
                suspendCancellableCoroutine<List<HistoryData>?> { continuation ->
                    sleepRepository.getHistoryData { historyDataList ->
                        continuation.resume(historyDataList) {
                            // 如果需要处理取消操作，可以在这里添加相应的逻辑
                        }
                    }
                }
            }

            // Update UI with the historyDataList
            val HistoryAdapter = historyDataList?.let { HistoryAdapter(it) } ?: HistoryAdapter(emptyList())

            viewPager.adapter = HistoryAdapter

            seekBar.valueFrom = 0f
            seekBar.valueTo = (historyDataList?.size?.minus(1) ?: 0).coerceAtLeast(1).toFloat()

            seekBar.stepSize = 1f
            seekBar.value = 0f

            seekBar.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
                @SuppressLint("RestrictedApi")
                override fun onStartTrackingTouch(slider: Slider) {
                    // Handle touch s tart
                }

                @SuppressLint("RestrictedApi")
                override fun onStopTrackingTouch(slider: Slider) {
                    val progress = slider.value.toInt()
                    viewPager.setCurrentItem(progress, false)
                }
            })
        }

        return view
    }
}