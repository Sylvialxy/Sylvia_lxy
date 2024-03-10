package com.liuxinyu.dreamscape.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ECGView : View {

    private val paint = Paint()
    private val data = mutableListOf<Float>()

    // 构造函数
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    private fun init() {
        paint.color = Color.BLUE
        paint.strokeWidth = 5f
    }

    fun addData(value: Float) {
        data.add(value)
        invalidate() // 刷新视图
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 在这里实现心电图的绘制逻辑，使用 canvas 进行绘制
        if (canvas != null) {
            drawECG(canvas)
        }
    }

    private fun drawECG(canvas: Canvas) {
        // 在这里实现心电图的绘制逻辑，使用绘图操作绘制数据
        // 示例：绘制折线图
        for (i in 1 until data.size) {
            val startX = (i - 1) * 10f // 假设每个数据点之间的间隔为 10
            val startY = data[i - 1] * 10f
            val endX = i * 10f
            val endY = data[i] * 10f
            canvas.drawLine(startX, startY, endX, endY, paint)
        }
    }
}