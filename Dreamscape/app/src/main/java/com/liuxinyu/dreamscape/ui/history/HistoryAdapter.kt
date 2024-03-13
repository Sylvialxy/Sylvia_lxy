package com.liuxinyu.dreamscape.ui.history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liuxinyu.dreamscape.R
import com.liuxinyu.dreamscape.data.model.HistoryData
import com.liuxinyu.dreamscape.data.model.SleepData

class HistoryAdapter (private val HistoryDataList: List<HistoryData>) :
    RecyclerView.Adapter<HistoryAdapter.SleepViewHolder>() {

    inner class SleepViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.tvDate)
        val sleepTimeTextView: TextView = itemView.findViewById(R.id.tvSleepTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.historyitem_sleep_page, parent, false)
        return SleepViewHolder(view)
    }

    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
        val HistoryData = HistoryDataList[position]
        holder.dateTextView.text = HistoryData.date
        holder.sleepTimeTextView.text = HistoryData.sleepTime
    }

    override fun getItemCount(): Int {
        return HistoryDataList.size
    }



}