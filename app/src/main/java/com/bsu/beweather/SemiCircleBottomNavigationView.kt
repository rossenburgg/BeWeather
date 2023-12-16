package com.bsu.beweather

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

class SemiCircleBottomNavigationView : View {
    private val paint: Paint = Paint()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width
        val height = height
        val radius = height.toFloat()
        val startAngle = 180F
        val sweepAngle = 180F

        paint.color = resources.getColor(android.R.color.holo_blue_light)
        canvas.drawArc(0F, height - 2 * radius, width.toFloat(), height.toFloat(), startAngle, sweepAngle, true, paint)
    }
}
