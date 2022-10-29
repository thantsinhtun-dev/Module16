package com.stone.module16.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.stone.module16.R


class CircularProgress @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) :
    View(context, attrs, defStyle) {
    private var min = 0
    private var max = 100
    private var progress = 0
    private var progressBarThickness = 4.0f
    private var activeProgressBarColor = Color.BLUE
    private var inactiveProgressBarColor = Color.CYAN

    private var rectF = RectF()
    private var startAngle = 270f


    private var inactivePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var activePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var textPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {

        context.withStyledAttributes(attrs,R.styleable.CircularProgress){
            min = getInt(R.styleable.CircularProgress_min,min)
            max = getInt(R.styleable.CircularProgress_max,max)
            progress = getInt(R.styleable.CircularProgress_progress,progress)
            progressBarThickness = getDimension(R.styleable.CircularProgress_progressBarThickness,progressBarThickness)
            activeProgressBarColor = getColor(R.styleable.CircularProgress_activeProgressBarColor, activeProgressBarColor)
            inactiveProgressBarColor = getColor(R.styleable.CircularProgress_inactiveProgressBarColor,inactiveProgressBarColor)
        }
        inactivePaint.style = Paint.Style.STROKE
        inactivePaint.color = inactiveProgressBarColor
        inactivePaint.strokeWidth = progressBarThickness

        activePaint.style = Paint.Style.STROKE
        activePaint.color = activeProgressBarColor
        activePaint.strokeWidth = progressBarThickness

        textPaint.textAlign = Paint.Align.CENTER
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val height = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val min = Math.min(width, height)
        setMeasuredDimension(min, min)
        rectF.set(
            progressBarThickness / 2,
            progressBarThickness / 2,
            min - (progressBarThickness / 2),
            min - (progressBarThickness / 2)
        )
        textPaint.textSize = min * 0.25f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawOval(rectF, inactivePaint)
        canvas?.drawText(
            progress.toString().plus("%"),
            width / 2f,
            (height / 2f) - ((textPaint.descent() + textPaint.ascent()) / 2),
            textPaint
        )
        val angle = ((360 * progress) / max).toFloat()
        canvas?.drawArc(rectF, startAngle, angle, false, activePaint)

    }
}