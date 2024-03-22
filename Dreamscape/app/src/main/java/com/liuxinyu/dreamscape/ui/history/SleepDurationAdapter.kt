package com.liuxinyu.dreamscape.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liuxinyu.dreamscape.R

class SleepDurationAdapter(private val data: List<SleepDuration>) :
    RecyclerView.Adapter<SleepDurationAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val durationTextView: TextView = itemView.findViewById(R.id.durationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sleep_duration, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.dateTextView.text = item.date
        holder.durationTextView.text = item.duration.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}