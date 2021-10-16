package com.example.gym.ui.detail

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.widget.ProgressBar
import androidx.core.content.res.ResourcesCompat
import com.example.gym.R
import java.util.*
import java.util.concurrent.TimeUnit

private const val GESTURE_THRESHOLD_DP = 70F

class TimerProgressBar(context: Context, attributeSet: AttributeSet) :
    ProgressBar(context, attributeSet, R.attr.progressBarStyle, R.style.Gym_ProgressBar) {

    private val textPaint: TextPaint
    private var timeText = "--:--"
    private var duration = 0L
    private val maxProgress = 100
    private val fontHeight : Int
    private var posX = 0
    private var posY = 0

    init {
        val res = resources
        // add Paint.ANTI_ALIAS_FLAG for see the difference
        textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        textPaint.density = res.displayMetrics.density
        textPaint.textSize = GESTURE_THRESHOLD_DP.toInt() * res.displayMetrics.scaledDensity
        textPaint.color = ResourcesCompat.getColor(res, R.color.orange, null)
        textPaint.isAntiAlias = true
        textPaint.style = Paint.Style.FILL
        textPaint.textAlign = Paint.Align.CENTER
        val fontMetrics = textPaint.fontMetrics
        fontHeight = (fontMetrics.descent + fontMetrics.ascent).toInt()
    }

    fun setDuration(time: Long) {
        duration = TimeUnit.MILLISECONDS.toSeconds(time)
    }

    @Synchronized
    fun updateProgressBar(timeRemainingMillis: Long) {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(timeRemainingMillis) % 60
        val seconds = TimeUnit.MILLISECONDS.toSeconds(timeRemainingMillis) % 60
        timeText = String.format("%d:%02d", minutes, seconds)
        val progress = maxProgress - seconds * maxProgress / duration
        setProgress(progress.toInt())
        invalidate()
    }

    @Synchronized
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(timeText, posX.toFloat(), posY.toFloat(), textPaint)
    }

    @Synchronized
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        posX = measuredWidth / 2
        posY = measuredHeight / 2 - fontHeight / 2
    }

}