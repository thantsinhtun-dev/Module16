package com.stone.module16.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.stone.module16.R

class LineProgressIndicator @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var min = 0
    private var max = 100
    private var progress = 0
    private var progressBarThickness = 4.0f
    private var activeProgressBarColor = Color.BLACK
    private var inactiveProgressBarColor = Color.GRAY


    private var inactivePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var activePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        context.withStyledAttributes(attrs, R.styleable.LineProgressIndicator) {
            min = getInt(R.styleable.LineProgressIndicator_minLineValue, min)
            max = getInt(R.styleable.LineProgressIndicator_maxLineValue, max)
            progress = getInt(R.styleable.LineProgressIndicator_lineProgressValue, progress)
            progressBarThickness = getDimension(
                R.styleable.LineProgressIndicator_lineProgressBarThickness,
                progressBarThickness
            )
            activeProgressBarColor =
                getColor(R.styleable.LineProgressIndicator_activeLineProgressBarColor, activeProgressBarColor)
            inactiveProgressBarColor = getColor(R.styleable.LineProgressIndicator_inactiveLineProgressBarColor, inactiveProgressBarColor)
        }

        inactivePaint.color = inactiveProgressBarColor
        inactivePaint.strokeWidth = progressBarThickness

        activePaint.color = activeProgressBarColor
        activePaint.strokeWidth = progressBarThickness

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawLine(0f, height/2f, width.toFloat(), height/2f, inactivePaint)

        val progressValue = ((width * progress) / max).toFloat()


        canvas?.drawLine(0f, height/2f, progressValue, height/2f, activePaint)


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        setMeasuredDimension(width, height)
    }


    fun setProgress(value: Int){
        progress = value
        invalidate()
    }
}